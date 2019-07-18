package com.mastertechsoftware.twine.api

import com.mastertechsoftware.twine.models.Deposit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 *
 */

object TwineAPI {
    const val BASE_URL = "https://api.twine.com/"
    private val service: TwineAPIInterface

    init {
        val httpClient = OkHttpClient().newBuilder()
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .client(httpClient.build())
            .build()

        service = retrofit.create(TwineAPIInterface::class.java)

    }

    suspend fun getDeposits(): List<Deposit> {
        var deposits = arrayListOf<Deposit>(Deposit("Rainy Ian", true),
            Deposit("Rainy Ian", true),
            Deposit("Goal Name", true),
            Deposit("Trip to Hawaii", true),
            Deposit("Kids", true),
            Deposit("Vacation", true),
            Deposit("Vacation", true)
            )
        // REAL API goes here
/*
        try {
            return service.getDeposits("userId")
        } catch (e: Exception) {
            Log.e("FlickrAPI", "Problems getting Photos", e)
        }
*/
        return deposits

    }
}