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
        }else{
            isLoading.postValue(false)
        }

    }

    fun deleteFavourite(characterId: String){
        val characterIds: ArrayList<String> = getFavouriteCharacters() as ArrayList<String>
        characterIds.remove(characterId)
        setFavouriteCharacters(characterIds)
        var newHeadList: ArrayList<HeadModel> = headsList.value?.filter { head -> head.id != characterId } as ArrayList<HeadModel>
        headsList.postValue(newHeadList)
    }
}