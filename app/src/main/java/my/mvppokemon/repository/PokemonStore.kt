package my.mvppokemon.repository

import my.mvppokemon.repository.models.Pokemon
import my.mvppokemon.repository.models.PokemonInfo

fun getPokemons(): List<Pokemon> = listOf(
    Pokemon("bulbasaur", 1),
    Pokemon("ivysaur", 2),
    Pokemon("venusaur", 3),
    Pokemon("charmander", 4),
    Pokemon("charmeleon", 5),
    Pokemon("charizard", 6),
)

fun getInfo(): PokemonInfo = PokemonInfo(
    id = 1,
    name = "bulbasaur",
    species = "bulbasaur",
    height = 7,
    weight = 69,
    abilities = listOf("overgrow", "chlorophyll"),
    types = listOf("grass", "poison"),

    hp = 45,
    attack = 49,
    defense = 49,
    spDefense = 65,
    spAttack = 65,
    speed = 45,
)