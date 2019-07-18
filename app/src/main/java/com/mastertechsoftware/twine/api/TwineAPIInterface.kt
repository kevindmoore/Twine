package com.mastertechsoftware.twine.api

import com.mastertechsoftware.twine.models.Deposit
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 */
interface TwineAPIInterface {
    @GET("deposits/{id}")
    suspend fun getDeposits(@Path("id") user: String): List<Deposit>
}