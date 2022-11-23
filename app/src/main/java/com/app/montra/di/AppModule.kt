package com.app.montra.di

import Constants
import com.app.montra.data.remote.BasicAuthInterceptor
import com.app.montra.data.remote.StytchApi
import com.app.montra.data.repository.StytchRepositoryImpl
import com.app.montra.domain.repository.StytchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)


    private val client = OkHttpClient.Builder()
        .addInterceptor(
            BasicAuthInterceptor(
                Constants.USERNAME,
                Constants.PASSWORD
            )
        )
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideStytchApi(): StytchApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(StytchApi::class.java)
    }

    @Provides
    @Singleton
    fun provideStytechRepository(api: StytchApi): StytchRepository {
        return StytchRepositoryImpl(api)
    }
}