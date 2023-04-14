package com.example.hogwartsdata.ui.view.home.housesList

import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.HouseModel
import com.example.hogwartsdata.databinding.HouseItemListBinding
import kotlin.coroutines.coroutineContext

class HouseListViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val binding = HouseItemListBinding.bind(view)
    private val view = view
    fun bind(house: HouseModel){
        binding.tvHouse.text = house.name
        binding.tvHouse.setOnClickListener {
            findNavController(view).navigate(R.id.action_homeFragment_to_houseDetailFragment2)
        }
    }
}