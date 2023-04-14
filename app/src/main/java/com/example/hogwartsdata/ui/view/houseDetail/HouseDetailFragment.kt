package com.example.hogwartsdata.ui.view.houseDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hogwartsdata.R
import com.example.hogwartsdata.databinding.FragmentHomeBinding
import com.example.hogwartsdata.databinding.FragmentHouseDetailBinding


class HouseDetailFragment : Fragment() {
    private lateinit var binding: FragmentHouseDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHouseDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
}