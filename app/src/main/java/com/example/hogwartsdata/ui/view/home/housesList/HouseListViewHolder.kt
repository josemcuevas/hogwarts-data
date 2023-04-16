package com.example.hogwartsdata.ui.view.home.housesList

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.HouseModel
import com.example.hogwartsdata.databinding.HouseItemListBinding

class HouseListViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val binding = HouseItemListBinding.bind(view)
    private val view = view
    fun bind(house: HouseModel){
        binding.tvHouse.text = house.name
        binding.tvHouse.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("houseId", house.id)
            findNavController(view).navigate(R.id.action_homeFragment_to_houseDetailFragment2, bundle)
        }
    }
}