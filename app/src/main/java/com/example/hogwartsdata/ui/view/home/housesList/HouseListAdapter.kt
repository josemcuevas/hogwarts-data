package com.example.hogwartsdata.ui.view.home.housesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.HouseModel

class HouseListAdapter(val houses: List<HouseModel>): RecyclerView.Adapter<HouseListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HouseListViewHolder(layoutInflater.inflate(R.layout.house_item_list, parent, false))
    }

    override fun onBindViewHolder(holder: HouseListViewHolder, position: Int) {
        val item: HouseModel = houses[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = houses.size
}