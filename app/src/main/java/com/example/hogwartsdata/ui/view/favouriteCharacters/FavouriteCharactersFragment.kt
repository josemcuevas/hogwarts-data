package com.example.hogwartsdata.ui.view.favouriteCharacters

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hogwartsdata.R
import com.example.hogwartsdata.data.model.HeadModel
import com.example.hogwartsdata.data.model.TraitModel
import com.example.hogwartsdata.databinding.FragmentFavouriteCharactersBinding
import com.example.hogwartsdata.ui.view.favouriteCharacters.favouritesList.FavouriteListAdapter
import com.example.hogwartsdata.ui.view.houseDetail.traitsList.TraitListAdapter
import com.example.hogwartsdata.ui.viewModel.favouriteCharacters.FavouriteCharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteCharactersFragment : Fragment() {
    private lateinit var binding: FragmentFavouriteCharactersBinding
    private lateinit var favouriteListAdapter: FavouriteListAdapter
    private val favouriteCharactersViewModel: FavouriteCharactersViewModel by viewModels()
    private lateinit var headList: ArrayList<HeadModel>
    private var initialHeadList: ArrayList<HeadModel> = ArrayList()
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteCharactersBinding.inflate(inflater, container, false)
        initSearchView(binding.svFavourites)
        //favouriteCharactersViewModel.onCreate()
        headListObserver()
        isLoadingObserver()
        favouriteCharactersViewModel.isLoading.postValue(true)
        favouriteCharactersViewModel.getFavourite()

        return binding.root
    }

    private fun initSearchView(search: SearchView) {
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(!query.isNullOrEmpty()){
                    searchFavouriteByName(query)
                }else{
                    headList.clear()
                    headList.addAll(initialHeadList)
                    favouriteListAdapter.notifyDataSetChanged()
                }
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if(newText==""){
                    headList.clear()
                    headList.addAll(initialHeadList)
                    favouriteListAdapter.notifyDataSetChanged()
                }
                return true
            }
        })
    }

    private fun buttonHandler(characterId: String){
        favouriteCharactersViewModel.deleteFavourite(characterId)
    }

    private fun headListObserver(){
        favouriteCharactersViewModel.headsList.observe(viewLifecycleOwner, Observer { headListObject ->
            if(!headListObject.isNullOrEmpty()){
                initialHeadList.addAll(headListObject)
                headList = headListObject
                initFavouriteRecyclerView(headList)
            }
        })
    }
    private fun isLoadingObserver(){
        favouriteCharactersViewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            if(isLoading){
                binding.progressBar.visibility = View.VISIBLE
            }else{
                binding.progressBar.visibility = View.GONE
            }
        })
    }
    private fun searchFavouriteByName(query: String){
        var filterArray: ArrayList<HeadModel> = initialHeadList
        var newHeadList: ArrayList<HeadModel> = filterArray.filter { head -> head.firstName == query || head.lastName == query } as ArrayList<HeadModel>
        headList.clear()
        headList.addAll(newHeadList)
        favouriteListAdapter.notifyDataSetChanged()
    }

    private fun initFavouriteRecyclerView(favouriteList: ArrayList<HeadModel>){
        favouriteListAdapter = FavouriteListAdapter(favouriteList, ::buttonHandler)
        binding.rvFavourites.layoutManager = LinearLayoutManager(context)
        binding.rvFavourites.adapter = favouriteListAdapter
    }

}