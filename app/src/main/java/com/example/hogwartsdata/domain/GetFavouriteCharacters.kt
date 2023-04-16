package com.example.hogwartsdata.domain

import com.example.hogwartsdata.data.Repository
import javax.inject.Inject

class GetFavouriteCharacters @Inject constructor(
    val repository: Repository
) {
    operator fun invoke(): List<String>{
        return repository.getFavouriteCharacters()
    }
}