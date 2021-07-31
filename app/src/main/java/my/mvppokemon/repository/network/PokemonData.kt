package my.mvppokemon.repository.network

import com.google.gson.annotations.SerializedName
import my.mvppokemon.repository.models.Pokemon
import my.mvppokemon.repository.persistence.PokemonEntity

data class PokemonData(
    @field:SerializedName("name") val name: String,
    @field:SerializedName("url") val url: String
) {
    fun convertToDomain(): Pokemon = Pokemon(name = name, id = extractId())
    fun convertToDatabase(): PokemonEntity = PokemonEntity(name = name, id = extractId())

    private fun extractId(): Int = url.split("/".toRegex()).dropLast(1).last().toInt()
}
