package my.mvppokemon.repository.network

import com.google.gson.annotations.SerializedName
import my.mvppokemon.repository.models.Pokemon
import my.mvppokemon.repository.persistence.PokemonEntity

data class ApiDTO (
    @field:SerializedName("count") val count: Long,
    @field:SerializedName("next") val next: String?,
    @field:SerializedName("previous") val previous: String?,
    @field:SerializedName("results") val results: List<PokemonData>,
) {
    fun convertToDomain(): List<Pokemon> = results.map { it.convertToDomain() }
    fun convertToDatabase(): List<PokemonEntity> = results.map { it.convertToDatabase() }
}