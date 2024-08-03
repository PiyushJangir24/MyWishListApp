package com.example.android_development

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.android_development.wishlist.data.WishDatabase
import com.example.android_development.wishlist.data.Wishrepository

object Graph {

    lateinit var database: WishDatabase

    val wishRepository by lazy {
        Wishrepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context,WishDatabase::class.java,"wishlish.db").build()
    }
}