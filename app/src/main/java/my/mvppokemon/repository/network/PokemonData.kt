package my.mvppokemon.repository.network

import com.google.gson.annotations.SerializedName
import my.mvppokemon.repository.models.Pokemon

data class PokemonData(
    @field:SerializedName("name") val name: String,
    @field:SerializedName("url") val url: String
) {
    fun convertToDomain(): Pokemon = Pokemon(name = name, url = url)
}
