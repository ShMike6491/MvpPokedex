package my.mvppokemon

import android.app.Application
import my.mvppokemon.dependencies.ApplicationComponent
import my.mvppokemon.dependencies.ApplicationModule
import my.mvppokemon.dependencies.DaggerApplicationComponent

class PokemonApp: Application() {
    companion object {
        lateinit var INSTANCE: PokemonApp
    }

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        appComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}