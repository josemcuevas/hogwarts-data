package com.example.hogwartsdata.ui.viewModel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hogwartsdata.data.model.HouseModel
import com.example.hogwartsdata.domain.GetHouses
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHouses: GetHouses
) :ViewModel() {
    var houses = MutableLiveData<List<HouseModel>>()
    var isLoading = MutableLiveData<Boolean>(false)

    fun onCreate(){
        viewModelScope.launch {
            var result = getHouses()
            if(!result.isEmpty()){
                houses.postValue(result)
            }
            isLoading.postValue(false)
        }

    }
}