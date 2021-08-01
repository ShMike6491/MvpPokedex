package my.mvppokemon.dependencies

import dagger.Module
import dagger.Provides
import my.mvppokemon.repository.IRepository
import my.mvppokemon.repository.Repository
import my.mvppokemon.repository.network.PokemonService
import my.mvppokemon.repository.persistence.DataBase
import my.mvppokemon.util.INetworkStatus

@Module
class RepositoryModule {
    @Provides
    fun repositoryProvider(
        db: DataBase,
        service: PokemonService,
        network: INetworkStatus
    ): IRepository = Repository(db, service, network)
}