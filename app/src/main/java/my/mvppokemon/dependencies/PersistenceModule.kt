package my.mvppokemon.dependencies

import androidx.room.Room
import dagger.Module
import dagger.Provides
import my.mvppokemon.PokemonApp
import my.mvppokemon.repository.persistence.DataBase
import javax.inject.Named
import javax.inject.Singleton

@Module
class PersistenceModule {
    @Provides
    @Named("databaseName")
    fun baseUrlProvider(): String = DataBase.DATABASE_NAME

    @Singleton
    @Provides
    fun databaseProvider(app: PokemonApp, @Named("databaseName") name: String): DataBase =
        Room.databaseBuilder(app, DataBase::class.java, name).build()
}