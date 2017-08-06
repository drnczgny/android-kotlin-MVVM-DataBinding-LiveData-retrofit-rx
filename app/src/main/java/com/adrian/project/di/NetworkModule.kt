package com.adrian.project.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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
//        val client = OkHttpClient.Builder().addInterceptor(object : Interceptor() {
//            @Throws(IOException::class)
//            fun intercept(chain: Interceptor.Chain): Downloader.Response {
//                val newRequest = chain.request().newBuilder()
//                        .build()
//                return chain.proceed(newRequest)
//            }
//        }).build()
//        return client
//    }


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

//    @Singleton
//    @Provides
//    public OkHttpClient providesOkHttpClient() {
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request newRequest = chain.request().newBuilder()
//                        .build();
//                return chain.proceed(newRequest);
//            }
//        }).build();
//        return client;
//    }

    @Singleton
    @Provides
    fun provideRetrofitForJsonPlaceholderApi(gson: Gson, client: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .client(client)
                .build()
        return retrofit
    }





}