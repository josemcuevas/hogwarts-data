package com.example.hogwartsdata.ui.view

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.hogwartsdata.R
import com.example.hogwartsdata.databinding.AlertDialogLogoutBinding
import com.example.hogwartsdata.domain.PostLoginState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var postLoginState: PostLoginState
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logOutButton -> {
                showLogOutDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun showLogOutDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alert_dialog_logout)
        val acceptButton = dialog.findViewById(R.id.acceptButton) as Button
        val cancelButton = dialog.findViewById(R.id.cancelButton) as Button

        acceptButton.setOnClickListener {
            dialog.dismiss()
            postLoginState(false)
            val id = findNavController(R.id.fragmentContainer).currentDestination?.id
            when(id){
                R.id.homeFragment -> {
                    findNavController(R.id.fragmentContainer).navigate(R.id.action_homeFragment_to_loginFragment2)
                }
                R.id.houseDetailFragment2 -> {
                    findNavController(R.id.fragmentContainer).navigate(R.id.action_houseDetailFragment2_to_loginFragment)
                }
                R.id.favouriteCharactersFragment -> {
                    findNavController(R.id.fragmentContainer).navigate(R.id.action_favouriteCharactersFragment_to_loginFragment)
                }
            }

        }
        cancelButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}