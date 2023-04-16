package com.example.hogwartsdata.ui.view.houseDetail.headsList

import android.annotation.SuppressLint
import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.HeadModel
import com.example.hogwartsdata.data.model.HouseModel
import com.example.hogwartsdata.databinding.HeadsItemListBinding
import com.example.hogwartsdata.databinding.HouseItemListBinding

class HeadListViewHolder(view: View, buttonHandler: (characterId: String)-> Unit, isFavourite:(characterId: String)-> Boolean): RecyclerView.ViewHolder(view){
    private val binding = HeadsItemListBinding.bind(view)
    private val buttonHandler = buttonHandler
    private val isFavourite = isFavourite
    @SuppressLint("SetTextI18n")
    fun bind(head: HeadModel){
        binding.tvTrait.text = "${head.firstName} ${head.lastName}"
        binding.favouriteButton.setOnClickListener {
            buttonHandler(head.id)
            binding.favouriteButton.text = "Favorito"
            binding.favouriteButton.isEnabled = false
        }
        if(isFavourite(head.id)){
            binding.favouriteButton.text = "Favorito"
            binding.favouriteButton.isEnabled = false
        }
    }
}