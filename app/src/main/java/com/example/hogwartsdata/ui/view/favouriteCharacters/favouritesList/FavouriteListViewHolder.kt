package com.example.hogwartsdata.ui.view.favouriteCharacters.favouritesList

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwartsdata.data.model.HeadModel
import com.example.hogwartsdata.databinding.FavouriteItemListBinding

class FavouriteListViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val binding = FavouriteItemListBinding.bind(view)
    private val view = view
    @SuppressLint("SetTextI18n")
    fun bind(head: HeadModel){
        binding.tvTrait.text = "${head.firstName} ${head.lastName}"
    }
}