package my.mvppokemon.repository

import my.mvppokemon.repository.models.Pokemon
import my.mvppokemon.repository.models.PokemonInfo

fun getPokemons(): List<Pokemon> = listOf(
    Pokemon("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
    Pokemon("ivysaur", "https://pokeapi.co/api/v2/pokemon/2/"),
    Pokemon("venusaur", "https://pokeapi.co/api/v2/pokemon/3/"),
    Pokemon("charmander", "https://pokeapi.co/api/v2/pokemon/4/"),
    Pokemon("charmeleon", "https://pokeapi.co/api/v2/pokemon/5/"),
    Pokemon("charizard", "https://pokeapi.co/api/v2/pokemon/6/"),
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