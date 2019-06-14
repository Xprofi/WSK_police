package ru.petrolplus.wsk_police.Utils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkClient{


    private val ROOT_URL_API: String  = "http://mad2019.hakta.pro"


    private fun createHttpClient(): Retrofit {

        val httpClient = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .callTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)

        return  Retrofit.Builder()
            .baseUrl(ROOT_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }


    fun httpClient(): ApiDirectory{
        return createHttpClient().create(ApiDirectory::class.java)
    }



}