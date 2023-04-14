package com.example.hogwartsdata.ui.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.HouseModel
import com.example.hogwartsdata.databinding.FragmentHomeBinding
import com.example.hogwartsdata.ui.view.home.housesList.HouseListAdapter
import com.example.hogwartsdata.ui.viewModel.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var houseListAdapter: HouseListAdapter
    private var houseList = listOf<HouseModel>()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        isLoadingObserver()
        detailButtonObserver()
        housesObserver()
        homeViewModel.isLoading.postValue(true)
        homeViewModel.onCreate()
        return binding.root
    }

    private fun detailButtonObserver(){
        binding.detailButton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_houseDetailFragment2)
        }
    }

    private fun housesObserver(){
        homeViewModel.houses.observe(viewLifecycleOwner, Observer { houses ->
            if(!houses.isNullOrEmpty()){
                houseList = houses
                initRecyclerView()
            }
        })
    }

    private fun isLoadingObserver(){
        homeViewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            if(isLoading){
                binding.progressBar.visibility = VISIBLE
            }else{
                binding.progressBar.visibility = GONE
            }
        })
    }

    private fun initRecyclerView(){
        houseListAdapter = HouseListAdapter(houseList)
        binding.rvHouses.layoutManager = LinearLayoutManager(context)
        binding.rvHouses.adapter = houseListAdapter
    }
}