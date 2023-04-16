package com.example.hogwartsdata.ui.view.houseDetail.traitsList

import android.annotation.SuppressLint
import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.TraitModel
import com.example.hogwartsdata.databinding.HouseItemListBinding
import com.example.hogwartsdata.databinding.TraitsItemListBinding

class TraitListViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val binding = TraitsItemListBinding.bind(view)
    private val view = view
    fun bind(trait: TraitModel){
        binding.tvTrait.text = trait.name
    }
}