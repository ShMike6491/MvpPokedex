package my.mvppokemon.repository.models

data class Pokemon(
    val name: String,
    val id: Int
) {
    fun getImageUrl() = "https://pokeres.bastionbot.org/images/pokemon/$id.png"
}