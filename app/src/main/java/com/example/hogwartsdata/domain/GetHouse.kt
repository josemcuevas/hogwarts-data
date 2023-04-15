package com.example.hogwartsdata.domain

import com.example.hogwartsdata.data.Repository
import com.example.hogwartsdata.data.model.HouseModel
import javax.inject.Inject

class GetHouse @Inject constructor(
    val repository: Repository
){
    suspend operator fun invoke(id: Int): HouseModel? {
        return repository.getHouse(id)
    }
}