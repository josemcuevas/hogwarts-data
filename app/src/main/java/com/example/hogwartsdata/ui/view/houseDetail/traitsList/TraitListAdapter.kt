package com.example.hogwartsdata.ui.view.houseDetail.traitsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.HeadModel
import com.example.hogwartsdata.data.model.TraitModel

class TraitListAdapter(val heads: List<TraitModel>): RecyclerView.Adapter<TraitListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TraitListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TraitListViewHolder(layoutInflater.inflate(R.layout.traits_item_list, parent, false))
    }

    override fun onBindViewHolder(holder: TraitListViewHolder, position: Int) {
        val item: TraitModel = heads[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = heads.size
}