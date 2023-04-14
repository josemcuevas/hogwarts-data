package com.example.hogwartsdata.data.network

import com.example.hogwartsdata.data.model.HouseModel
import retrofit2.Response
import retrofit2.http.GET

interface HouseApiClient {
    @GET("Houses")
    suspend fun getAllHouses(): Response<List<HouseModel>>
}