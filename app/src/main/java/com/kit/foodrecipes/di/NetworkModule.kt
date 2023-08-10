package com.kit.foodrecipes.di

import com.kit.data.datasource.remote.APIService
import com.kit.data.util.Constants

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHTTP(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.DAYS)
            .readTimeout(1, TimeUnit.DAYS)
            .writeTimeout(1, TimeUnit.DAYS)
            .retryOnConnectionFailure(true)
            .callTimeout(1, TimeUnit.DAYS)
            .hostnameVerifier { _, _ -> true }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }
}