package my.mvppokemon.dependencies

import dagger.Module
import dagger.Provides
import my.mvppokemon.PokemonApp
import my.mvppokemon.repository.network.PokemonService
import my.mvppokemon.util.INetworkStatus
import my.mvppokemon.util.NetworkStatusImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Named("baseUrl")
    fun baseUrlProvider(): String = PokemonService.BASE_URL

    @Provides
    fun loggerProvider(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

    @Singleton
    @Provides
    fun okHttpProvider(logger: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(logger).build()

    @Singleton
    @Provides
    fun retrofitProvider(@Named("baseUrl") baseUrl: String, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun serviceProvider(retrofit: Retrofit): PokemonService =
        retrofit.create(PokemonService::class.java)

    @Provides
    fun networkStatusProvider(app: PokemonApp): INetworkStatus =
        NetworkStatusImpl(app)
}