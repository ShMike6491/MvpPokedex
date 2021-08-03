package my.mvppokemon.navigation

import com.github.terrakok.cicerone.Screen
import my.mvppokemon.repository.models.Pokemon

interface IScreens {
    fun home(): Screen
    fun details(data: Pokemon): Screen
}