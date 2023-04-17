package com.example.hogwartsdata.ui.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hogwartsdata.R
import com.example.hogwartsdata.databinding.FragmentLoginBinding
import com.example.hogwartsdata.ui.viewModel.login.LoginState
import com.example.hogwartsdata.ui.viewModel.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if(loginViewModel.isLoggedIt()){
            (activity as AppCompatActivity?)!!.supportActionBar!!.show()
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
        }
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        loginStateObserver()
        loginButtonObserver()
        return binding.root
    }

    private fun loginButtonObserver(){
        binding.loginButton.setOnClickListener{
            val user: String = binding.editTextUser.text.toString()
            val password: String = binding.editTextPassword.text.toString()

            if(user.isEmpty() || password.isEmpty()){
                Toast.makeText(context, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                loginViewModel.doLogin(user, password)
            }
        }
    }

    private fun loginStateObserver(){
        loginViewModel.loginState.observe(viewLifecycleOwner, Observer { loginState ->
            when(loginState){
                LoginState.IDLE -> {}
                LoginState.SUCCESS -> {
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
                    loginViewModel.setLoginState(true)
                    loginViewModel.resetLoginState()
                }
                LoginState.ERROR -> {
                    Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    loginViewModel.resetLoginState()
                }
                else -> {}
            }
        })
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }


}