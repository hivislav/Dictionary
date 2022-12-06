package com.hivislav.dictionary.data.datasource.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory (
    private val interceptor: BaseInterceptor
) {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_LOCATIONS)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(createOkHttpClient(interceptor))
        .build()

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        return httpClient.build()
    }

    val apiService: ApiService = retrofit.create(ApiService::class.java)

    companion object {
        private const val BASE_URL_LOCATIONS =
            "https://dictionary.skyeng.ru/api/public/v1/"
    }
}