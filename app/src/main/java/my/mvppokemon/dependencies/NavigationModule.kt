package my.mvppokemon.dependencies

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import my.mvppokemon.navigation.IScreens
import my.mvppokemon.navigation.ScreenNavigation
import javax.inject.Singleton

@Module
class NavigationModule {
    var cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun ciceroneProvider(): Cicerone<Router> = cicerone

    @Singleton
    @Provides
    fun navHolderProvider(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Singleton
    @Provides
    fun routerProvider(): Router = cicerone.router

    @Singleton
    @Provides
    fun screensProvider(): IScreens = ScreenNavigation()
}