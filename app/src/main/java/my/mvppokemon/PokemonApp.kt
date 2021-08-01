package my.mvppokemon

import android.app.Application
import com.github.terrakok.cicerone.Cicerone

class PokemonApp: Application() {
    companion object {
        lateinit var INSTANCE: PokemonApp
    }

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}