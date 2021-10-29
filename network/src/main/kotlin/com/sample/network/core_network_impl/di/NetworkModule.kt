package com.sample.network.core_network_impl.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.sample.network.BuildConfig
import com.sample.network.core_network_impl.data.rest.MemesRestService
import com.sample.network.core_network_impl.data.rest.NewsRestService
import com.sample.network.core_network_impl.data.rest.PhotoRestService
import com.sample.network.core_network_impl.data.utils.InternetConnectionService
import com.sample.network.core_network_impl.data.utils.InternetInterceptor
import com.sample.network.core_network_impl.data.utils.createRestService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

//    @Provides
//    @Singleton
//    fun provideInternetConnectionService(
//        appContext: Context
//    ): InternetConnectionService = InternetConnectionService(appContext)
//
//    @Provides
//    @Singleton
//    fun provideInternetInterceptor(
//        netService: InternetConnectionService
//    ): InternetInterceptor = InternetInterceptor(netService)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        //  netInterceptor: InternetInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .apply {
                // addInterceptor(netInterceptor)
                addInterceptor(HttpLoggingInterceptor().also {
                    it.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                })
                connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            }.build()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create(GsonBuilder().create())

    @Singleton
    @Provides
    fun provideMemesApiService(
        gsonConverterFactory: GsonConverterFactory, client: OkHttpClient
    ): MemesRestService =
        createRestService(
            gsonConverterFactory,
            client,
            BuildConfig.MEMES_BASE_URL,
            MemesRestService::class.java
        )

    @Singleton
    @Provides
    fun provideNewsApiService(
        gsonConverterFactory: GsonConverterFactory, client: OkHttpClient
    ): NewsRestService =
        createRestService(
            gsonConverterFactory,
            client,
            BuildConfig.NEWS_BASE_URL,
            NewsRestService::class.java
        )

    @Singleton
    @Provides
    fun providePhotoRestService(
        gsonConverterFactory: GsonConverterFactory, client: OkHttpClient
    ): PhotoRestService =
        createRestService(
            gsonConverterFactory,
            client,
            BuildConfig.PHOTO_BASE_URL,
            PhotoRestService::class.java
        )


    companion object {
        private const val CONNECT_TIMEOUT = 15000L
        private const val READ_TIMEOUT = 15000L
        private const val WRITE_TIMEOUT = 15000L
    }
}