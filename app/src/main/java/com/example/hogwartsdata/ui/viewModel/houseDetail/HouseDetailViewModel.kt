package com.example.hogwartsdata.ui.viewModel.houseDetail

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hogwartsdata.data.model.HeadModel
import com.example.hogwartsdata.data.model.HouseModel
import com.example.hogwartsdata.domain.GetFavouriteCharacters
import com.example.hogwartsdata.domain.GetHouse
import com.example.hogwartsdata.domain.GetHouses
import com.example.hogwartsdata.domain.SetFavouriteCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HouseDetailViewModel @Inject constructor(
    private val getHouse: GetHouse,
    private val getFavouriteCharacters: GetFavouriteCharacters,
    private val setFavouriteCharacters: SetFavouriteCharacters
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

    fun addFavourite(characterId: String){
        val characterIds: ArrayList<String> = getFavouriteCharacters() as ArrayList<String>
        characterIds.add(characterId)
        setFavouriteCharacters(characterIds)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun isFavourite(characterId: String): Boolean{
        val characterIds: ArrayList<String> = getFavouriteCharacters() as ArrayList<String>
        return characterIds.stream().anyMatch { character -> character == characterId }
    }
}