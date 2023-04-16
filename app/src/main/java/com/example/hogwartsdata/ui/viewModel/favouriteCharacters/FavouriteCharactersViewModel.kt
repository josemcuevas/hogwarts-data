package com.example.hogwartsdata.ui.viewModel.favouriteCharacters

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
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList
import kotlin.jvm.optionals.getOrNull

@HiltViewModel
class FavouriteCharactersViewModel @Inject constructor(
    private val setFavouriteCharacters: SetFavouriteCharacters,
    private val getFavouriteCharacters: GetFavouriteCharacters,
    private val getHouses: GetHouses
) : ViewModel() {
    var isLoading = MutableLiveData<Boolean>(false)
    var headsList = MutableLiveData<ArrayList<HeadModel>>()
    fun onCreate(){
        val mockedCharacters: List<String> = listOf("530da97d-5a83-4ea6-bc15-790edf5b5efc", "9915c5f8-9177-4f63-bba8-d04387a404f9")
        setFavouriteCharacters(mockedCharacters)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getFavourite(){
        val characterIds: List<String> = getFavouriteCharacters()
        var characterList: ArrayList<HeadModel> = ArrayList()
        if(!characterIds.isEmpty()){
            viewModelScope.launch {
                val houses: List<HouseModel> = getHouses()
                houses.forEach{house ->
                    house.heads.forEach { head ->
                        if(characterIds.stream().anyMatch { character -> character == head.id}){
                            characterList.add(head)
                        }
                    }
                }
                headsList.postValue(characterList)
                isLoading.postValue(false)
            }
        }

    }
}