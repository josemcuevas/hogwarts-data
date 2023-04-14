package com.example.hogwartsdata.data

import com.example.hogwartsdata.data.model.HouseModel
import com.example.hogwartsdata.data.network.HouseService
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: HouseService
){
    suspend fun getAllHousesFromApi(): List<HouseModel>{
        return api.getHouses()
    }
}