package com.example.hogwartsdata.ui.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hogwartsdata.R
import com.example.hogwartsdata.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        detailButtonObserver()
        return binding.root
    }

    private fun detailButtonObserver(){
        binding.detailButton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_houseDetailFragment2)
        }
    }
}