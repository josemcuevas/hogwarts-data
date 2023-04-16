package com.example.hogwartsdata.domain

import com.example.hogwartsdata.data.Repository
import javax.inject.Inject

class SetFavouriteCharacters @Inject constructor(
    val repository: Repository
) {
    operator fun invoke(characterIds: List<String>) {
        return repository.setFavouriteCharacters(characterIds)
    }
}