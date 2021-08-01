package my.mvppokemon.repository

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import my.mvppokemon.repository.models.Pokemon
import my.mvppokemon.repository.models.PokemonInfo
import my.mvppokemon.repository.network.ApiDTO
import my.mvppokemon.repository.network.PokemonService
import my.mvppokemon.repository.persistence.DataBase
import my.mvppokemon.repository.persistence.convertToDomainPokemon
import my.mvppokemon.util.INetworkStatus

class Repository(
    private val db: DataBase,
    private val service: PokemonService,
    private val internet: INetworkStatus
) : IRepository {
    override fun getPokemons(): Single<List<Pokemon>> =
        internet.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                getPokemonsFromNetwork()
            } else {
                getPokemonsFromDb()
            }
        }.subscribeOn(Schedulers.io())

    override fun getPokemonByName(name: String): Single<PokemonInfo> =
        internet.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                getInfoFromNetwork(name)
            } else {
                getInfoFromDb(name)
            }
        }.subscribeOn(Schedulers.io())

    private fun getPokemonsFromNetwork(): Single<List<Pokemon>> = service.getPokemons()
        .flatMap { networkData ->
            Single.fromCallable {
                cachePokemons(networkData)
                networkData.convertToDomain()
            }
        }

    private fun cachePokemons(networkData: ApiDTO) =
        db.pokemonDao().insert(networkData.convertToDatabase())

    private fun getPokemonsFromDb(): Single<List<Pokemon>> =
        Single.fromCallable { db.pokemonDao().getAll().convertToDomainPokemon() }

    private fun getInfoFromNetwork(name: String): Single<PokemonInfo> {
        val roomData = db.pokemonDao().findByName(name)
        return if (roomData == null || !roomData.containsInfo) {
            service.getPokemonInfo(name).flatMap { networkData ->
                Single.fromCallable {
                    db.pokemonDao().update(networkData.convertToDatabase())
                    networkData.convertToDomain()
                }
            }
        } else {
            Single.fromCallable { roomData.convertToDomainInfoModel() }
        }
    }

    private fun getInfoFromDb(name: String): Single<PokemonInfo> =
        Single.fromCallable {
            val roomData = db.pokemonDao().findByName(name)
                ?: throw RuntimeException("No info in cache")
            roomData.convertToDomainInfoModel()
        }
}