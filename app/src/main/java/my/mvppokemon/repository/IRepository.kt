package my.mvppokemon.repository

import io.reactivex.rxjava3.core.Single
import my.mvppokemon.repository.models.Pokemon
import my.mvppokemon.repository.models.PokemonInfo

interface IRepository {
    fun getPokemons(): Single<List<Pokemon>>
    fun getPokemonByName(name: String): Single<PokemonInfo>
}