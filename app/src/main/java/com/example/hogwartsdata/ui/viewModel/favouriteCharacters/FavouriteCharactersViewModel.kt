package com.example.hogwartsdata.ui.viewModel.favouriteCharacters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hogwartsdata.data.model.HouseModel
import com.example.hogwartsdata.domain.GetHouse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteCharactersViewModel @Inject constructor(
    private val getHouse: GetHouse
) : ViewModel() {
    var house = MutableLiveData<HouseModel?>()
    var isLoading = MutableLiveData<Boolean>(false)

    fun onCreate(id: String?){
        viewModelScope.launch {

            val result = id?.let { getHouse(it) }
            house.postValue(result)
            isLoading.postValue(false)
        }

    }
}