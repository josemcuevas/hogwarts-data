package com.example.hogwartsdata.ui.view.favouriteCharacters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.HeadModel
import com.example.hogwartsdata.data.model.TraitModel
import com.example.hogwartsdata.databinding.FragmentFavouriteCharactersBinding
import com.example.hogwartsdata.ui.view.favouriteCharacters.favouritesList.FavouriteListAdapter
import com.example.hogwartsdata.ui.view.houseDetail.traitsList.TraitListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteCharactersFragment : Fragment() {
    private lateinit var binding: FragmentFavouriteCharactersBinding
    private lateinit var favouriteListAdapter: FavouriteListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteCharactersBinding.inflate(inflater, container, false)
        initSearchView(binding.svFavourites)
        return binding.root
    }

    private fun initSearchView(search: SearchView) {
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(!query.isNullOrEmpty()){
                    searchFavouriteByName(query.lowercase())
                }
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })
    }

    private fun searchFavouriteByName(query: String){

    }

    private fun initFavouriteRecyclerView(favouriteList: List<HeadModel>){
        favouriteListAdapter = FavouriteListAdapter(favouriteList)
        binding.rvFavourites.layoutManager = LinearLayoutManager(context)
        binding.rvFavourites.adapter = favouriteListAdapter
    }

}