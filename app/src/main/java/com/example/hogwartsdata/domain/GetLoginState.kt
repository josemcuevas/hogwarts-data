package com.example.hogwartsdata.domain

import com.example.hogwartsdata.data.Repository
import javax.inject.Inject

class GetLoginState @Inject constructor(
    val repository: Repository
){
    operator fun invoke(): Boolean{
        return repository.getLoginState()
    }
}