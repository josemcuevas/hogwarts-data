package com.example.hogwartsdata.domain

import com.example.hogwartsdata.data.Repository
import com.example.hogwartsdata.data.model.HouseModel
import javax.inject.Inject

class GetHouses @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<HouseModel> {
        return repository.getAllHousesFromApi()
    }
}