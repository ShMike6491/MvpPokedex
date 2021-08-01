package my.mvppokemon.dependencies

import dagger.Component

@Component(modules = [
    ApplicationModule::class,
    NavigationModule::class,
    NetworkModule::class,
    PersistenceModule::class,
    RepositoryModule::class
])
interface ApplicationComponent {}