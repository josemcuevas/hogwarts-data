package com.example.hogwartsdata.domain

import com.example.hogwartsdata.data.Repository
import javax.inject.Inject

class CheckUser @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(user: String, password: String): Boolean {
        return repository.postUserLogin(user, password)
    }
}