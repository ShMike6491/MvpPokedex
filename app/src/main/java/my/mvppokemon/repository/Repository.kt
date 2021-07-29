package my.mvppokemon.repository

import io.reactivex.rxjava3.core.Single
import my.mvppokemon.repository.models.Pokemon
import my.mvppokemon.repository.models.PokemonInfo

class Repository {
    fun getPokemons(): Single<List<Pokemon>> =  TODO()

    fun getPokemonByName(name: String): Single<PokemonInfo> = TODO()
}