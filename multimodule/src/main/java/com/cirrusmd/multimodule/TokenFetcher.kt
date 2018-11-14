package com.cirrusmd.exampleapp

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by Cory Clark on 12/5/17
 */
interface TokenFetcher {

    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    @POST("sandbox/sessions")
    fun getSessionJwt(@Body() request: TokenRequest): Call<SessionToken>

    @DELETE("sandbox/history")
    fun deleteUserHistory(@Body() request: TokenRequest): Call<Void>

    companion object {
        fun retrofit(): TokenFetcher {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .baseUrl("https://staging.cirrusmd.com/sdk/v1/")
                    .build()

            return retrofit.create(TokenFetcher::class.java)
        }
    }
}