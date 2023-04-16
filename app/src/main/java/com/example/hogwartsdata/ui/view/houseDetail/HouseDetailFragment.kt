package com.example.hogwartsdata.ui.view.houseDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.HeadModel
import com.example.hogwartsdata.data.model.HouseModel
import com.example.hogwartsdata.data.model.TraitModel
import com.example.hogwartsdata.databinding.FragmentHomeBinding
import com.example.hogwartsdata.databinding.FragmentHouseDetailBinding
import com.example.hogwartsdata.ui.view.home.housesList.HouseListAdapter
import com.example.hogwartsdata.ui.view.houseDetail.headsList.HeadListAdapter
import com.example.hogwartsdata.ui.view.houseDetail.traitsList.TraitListAdapter
import com.example.hogwartsdata.ui.viewModel.houseDetail.HouseDetailViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HouseDetailFragment : Fragment() {
    private lateinit var binding: FragmentHouseDetailBinding
    private val houseDetailViewModel: HouseDetailViewModel by viewModels()
    private lateinit var headListAdapter: HeadListAdapter
    private lateinit var traitListAdapter: TraitListAdapter
    private var houseId: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHouseDetailBinding.inflate(inflater, container, false)
        houseId = arguments?.getString("houseId")
        isLoadingObserver()
        houseObserver()
        houseDetailViewModel.isLoading.postValue(true)
        houseDetailViewModel.onCreate(houseId)

        return binding.root
    }

    private fun isLoadingObserver(){
        houseDetailViewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            if(isLoading){
                binding.progressBar2.visibility = View.VISIBLE
            }else{
                binding.progressBar2.visibility = View.GONE
            }
        })
    }

    private fun houseObserver(){
        houseDetailViewModel.house.observe(viewLifecycleOwner, Observer { house ->
            if(house != null){
                binding.animalTv.text = "Animal: ${house.animal}"
                binding.colorsTv.text = "Color: ${house.houseColors}"
                binding.commonRoomTv.text = "Sala Común: ${house.commonRoom}"
                binding.elementTv.text = "Elemento: ${house.element}"
                binding.founderTv.text = "Fundador: ${house.founder}"
                binding.ghostTv.text = "Fantasma: ${house.ghost}"
                initHeadRecyclerView(house.heads)
                initTraitRecyclerView(house.traits)
            }
        })
    }

    private fun initHeadRecyclerView(headList: List<HeadModel>){
        headListAdapter = HeadListAdapter(headList)
        binding.headsRv.layoutManager = LinearLayoutManager(context)
        binding.headsRv.adapter = headListAdapter
    }

    private fun initTraitRecyclerView(traitList: List<TraitModel>){
        traitListAdapter = TraitListAdapter(traitList)
        binding.traitsRv.layoutManager = LinearLayoutManager(context)
        binding.traitsRv.adapter = traitListAdapter
    }
}