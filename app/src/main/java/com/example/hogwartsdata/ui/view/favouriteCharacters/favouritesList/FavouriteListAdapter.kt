package com.example.hogwartsdata.ui.view.favouriteCharacters.favouritesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.HeadModel

class FavouriteListAdapter(val favourites: List<HeadModel>, buttonHandler: (characterId: String)-> Unit): RecyclerView.Adapter<FavouriteListViewHolder>() {
    private val buttonHandler = buttonHandler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavouriteListViewHolder(layoutInflater.inflate(R.layout.favourite_item_list, parent, false), buttonHandler)
    }

    override fun onBindViewHolder(holder: FavouriteListViewHolder, position: Int) {
        val item: HeadModel = favourites[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = favourites.size
}