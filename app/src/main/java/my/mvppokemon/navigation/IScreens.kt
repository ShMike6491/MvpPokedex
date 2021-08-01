package my.mvppokemon.navigation

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun home(): Screen
    fun details(): Screen
}