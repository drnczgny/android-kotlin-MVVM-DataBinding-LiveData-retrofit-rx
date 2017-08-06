package com.adrian.project.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by cadri on 2017. 08. 06..
 */

@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideGson(): Gson {
        val gson = GsonBuilder()
                .setLenient()
                .create()
        return gson
    }

//    @Singleton
//    @Provides
//    fun providesOkHttpClient(): OkHttpClient {
//        val  client = OkHttpClient().newBuilder().addInterceptor(Interceptor {
//            fun intercept(chain: Interceptor.Chain): Downloader.Response {
//                val newRequest = chain.request().newBuilder()
//                        .build()
//                return chain.proceed(newRequest)
//            }
//        }).build()
//        return client
//    }

    @Singleton
    @Provides
    @Named("jsonplaceholderapi")
    fun provideRetrofitForJsonPlaceholderApi(gson: Gson): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .client(client)
                .build()
        return retrofit
    }





}