package my.mvppokemon.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import my.mvppokemon.features.details.DetailsFragment
import my.mvppokemon.features.home.HomeFragment

class ScreenNavigation: IScreens {
    override fun home(): Screen = FragmentScreen { HomeFragment.newInstance() }

    override fun details(): Screen = FragmentScreen {
        TODO("pass argument here")
        DetailsFragment.newInstance()
    }
}