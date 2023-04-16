package com.example.hogwartsdata.data.database

import android.content.Context

class SharedPreferencesStorage (val context: Context) {
    val STORAGE_NAME = "HogwartsDb"
    val LOGIN_STATE = "login_state"
    val FAVOURITE_CHARACTERS = "favourite_characters"

    val storage = context.getSharedPreferences(STORAGE_NAME, 0)

    fun saveLoginState(state: Boolean){
        storage.edit().putBoolean(LOGIN_STATE, state).apply()
    }

    fun getLoginState(): Boolean{
        return storage.getBoolean(LOGIN_STATE, false)
    }

    fun saveFavouriteCharacters(characterIds: List<String>){
        val sb : StringBuilder = StringBuilder()
        characterIds.forEach { characterId ->
            sb.append(characterId).append(",")
        }
        storage.edit().putString(FAVOURITE_CHARACTERS, sb.toString()).apply()
    }

    fun getFavouriteCharacters(): List<String>{
        val rawCharacterIds: String = storage.getString(FAVOURITE_CHARACTERS, "")!!
        if(rawCharacterIds != ""){
            return rawCharacterIds.split(",")
        }
        return emptyList()
    }
}