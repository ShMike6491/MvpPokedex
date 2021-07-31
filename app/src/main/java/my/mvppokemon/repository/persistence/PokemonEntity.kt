package my.mvppokemon.repository.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey
import my.mvppokemon.repository.models.Pokemon
import my.mvppokemon.repository.models.PokemonInfo

@Entity(tableName = "pokemons")
data class PokemonEntity(
    val containsInfo: Boolean = false,

    val id: Int,
    @PrimaryKey val name: String,
    val species: String? = null,
    val height: Int? = null,
    val weight: Int? = null,
    val abilities: List<String>? = null,
    val types: List<String>? = null,

    val hp: Int? = null,
    val attack: Int? = null,
    val defense: Int? = null,
    val spDefense: Int? = null,
    val spAttack: Int? = null,
    val speed: Int? = null,
) {
    fun convertToDomainPokemon(): Pokemon = Pokemon(name = name, id = id)
    fun convertToDomainInfoModel(): PokemonInfo = PokemonInfo(
        id = id,
        name = name,
        species = species ?: "",
        height = height ?: 0,
        weight = weight ?: 0,
        abilities = abilities ?: emptyList(),
        types = types ?: emptyList(),
        hp = hp ?: 0,
        attack = attack ?: 0,
        defense = defense ?: 0,
        spDefense = spDefense ?: 0,
        spAttack = spAttack ?: 0,
        speed = speed ?: 0
    )
}