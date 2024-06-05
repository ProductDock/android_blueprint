package com.blueprint.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.blueprint.featureA.service.FeatureAService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.time.Duration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @[Provides Singleton]
    fun provideBaseUrl(): HttpUrl = "http://10.0.2.2:8083/api/v1/".toHttpUrl()

    @[Provides Singleton]
    fun provideHttpLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    @[Provides Singleton]
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder().apply {
        this.addInterceptor(provideHttpLoggingInterceptor())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @[Provides Singleton]
    fun providePublicRetrofit(
        okHttpClientBuilder: OkHttpClient.Builder,
        gson: Gson,
        baseUrl: HttpUrl,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(
            okHttpClientBuilder
                .writeTimeout(Duration.ZERO)
                .readTimeout(Duration.ZERO)
                .connectTimeout(Duration.ZERO)
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @[Singleton Provides]
    fun provideTaskService(retrofit: Retrofit): FeatureAService =
        retrofit.create()
}