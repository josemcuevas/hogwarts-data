package com.example.hogwartsdata.ui.view.houseDetail.headsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.HeadModel
import com.example.hogwartsdata.data.model.HouseModel

class HeadListAdapter(val heads: List<HeadModel>, buttonHandler: (characterId: String)-> Unit, isFavourite:(characterId: String)-> Boolean ): RecyclerView.Adapter<HeadListViewHolder>() {
    private val buttonHandler = buttonHandler
    private val isFavourite = isFavourite
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeadListViewHolder(layoutInflater.inflate(R.layout.heads_item_list, parent, false), buttonHandler, isFavourite)
    }

    override fun onBindViewHolder(holder: HeadListViewHolder, position: Int) {
        val item: HeadModel = heads[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = heads.size
}