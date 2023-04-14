package com.example.hogwartsdata.data.network

import com.example.hogwartsdata.data.model.HouseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HouseService @Inject constructor(
    private val api: HouseApiClient
) {
    suspend fun getHouses(): List<HouseModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllHouses()
            response.body() ?: emptyList()
        }
    }
}