package com.example.android_development

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android_development.wishlist.data.Wish
import com.example.android_development.wishlist.data.Wishrepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel (private val wishrepository: Wishrepository = Graph.wishRepository) : ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString: String){
        wishTitleState = newString
    }
    fun onWishDescriptionChange(newString: String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes : Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishrepository.getWishes()
        }
    }

    fun addWish(wish:Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishrepository.addWish(wish = wish)
        }
    }

    fun getAWish(id : Long) : Flow<Wish>{
        return wishrepository.getAWish(id)
    }

    fun updateWish(wish : Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishrepository.updateWish(wish = wish)
        }
    }

    fun deleteWish(wish : Wish){
        viewModelScope.launch {
            wishrepository.deleteWish(wish = wish)
        }
    }

}