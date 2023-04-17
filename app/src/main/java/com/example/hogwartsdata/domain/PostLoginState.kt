package com.example.hogwartsdata.domain

import com.example.hogwartsdata.data.Repository
import javax.inject.Inject

class PostLoginState @Inject constructor(
    val repository: Repository
){
    operator fun invoke(state: Boolean){
        repository.setLoginState(state)
    }
}