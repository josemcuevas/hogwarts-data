package com.example.hogwartsdata.ui.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hogwartsdata.R
import com.example.hogwartsdata.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        loginButtonObserver()
        return binding.root
    }

    private fun loginButtonObserver(){
        binding.loginButton.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
        }
    }
}