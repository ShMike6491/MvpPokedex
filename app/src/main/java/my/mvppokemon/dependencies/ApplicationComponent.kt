package my.mvppokemon.dependencies

import dagger.Component
import my.mvppokemon.features.MainActivity
import my.mvppokemon.features.MainPresenter
import my.mvppokemon.features.details.DetailsPresenter
import my.mvppokemon.features.home.HomePresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    NavigationModule::class,
    NetworkModule::class,
    PersistenceModule::class,
    RepositoryModule::class
])
interface ApplicationComponent {
    fun inject(MainActivity: MainActivity)
    fun inject(MainPresenter: MainPresenter)
    fun inject(HomePresenter: HomePresenter)
    fun inject(DetailsPresenter: DetailsPresenter)
}