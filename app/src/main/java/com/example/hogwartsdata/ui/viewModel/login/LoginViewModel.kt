package com.example.hogwartsdata.ui.viewModel.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hogwartsdata.domain.CheckUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val checkUser: CheckUser
): ViewModel(){
    val loginState = MutableLiveData<LoginState>(LoginState.IDLE)

    fun doLogin(user: String, password: String){
        val response: Boolean = checkUser(user, password)
        if(response){
            loginState.postValue(LoginState.SUCCESS)
        }else{
            loginState.postValue(LoginState.ERROR)
        }
    }

    fun resetLoginState(){
        loginState.postValue(LoginState.IDLE)
    }
}