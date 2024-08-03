package com.example.android_development.wishlist.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Wish::class],
    version = 1,
    exportSchema = false
)
abstract class WishDatabase : RoomDatabase() {
    abstract fun wishDao() : WishDao
}