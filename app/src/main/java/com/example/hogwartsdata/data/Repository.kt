package com.example.hogwartsdata.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.hogwartsdata.data.database.SharedPreferencesStorage
import com.example.hogwartsdata.data.model.HouseModel
import com.example.hogwartsdata.data.model.UserModel
import com.example.hogwartsdata.data.network.HouseService
import java.util.Arrays
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: HouseService,
    private val sharedPreferences: SharedPreferencesStorage
){
    private lateinit var mockedUserList: List<UserModel>
    suspend fun getAllHousesFromApi(): List<HouseModel>{
        return api.getHouses()
    }

    suspend fun getHouse(id:String): HouseModel?{
        return api.getHouse(id)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun postUserLogin(loginUser:String, loginPassword:String): Boolean {
        initializeUsers()
        val loginState: Boolean = mockedUserList.stream().anyMatch { user -> user.user == loginUser && user.password == loginPassword }

        return loginState
    }
    private fun initializeUsers(){
        val user1: UserModel = UserModel("Paco", "1111")
        val user2: UserModel = UserModel("Raquel", "2222")
        mockedUserList = listOf<UserModel>(user1, user2)
    }

    fun setLoginState(state: Boolean){
        sharedPreferences.saveLoginState(state)
    }

    fun getLoginState(): Boolean{
        return sharedPreferences.getLoginState()
    }

    fun setFavouriteCharacters(charactersIds: List<String> ){
        sharedPreferences.saveFavouriteCharacters(charactersIds)
    }

    fun getFavouriteCharacters(): List<String>{
        return sharedPreferences.getFavouriteCharacters()
    }
}