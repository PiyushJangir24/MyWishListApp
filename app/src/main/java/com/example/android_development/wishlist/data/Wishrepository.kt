package com.example.android_development.wishlist.data

import kotlinx.coroutines.flow.Flow

class Wishrepository (private val wishDao : WishDao) {

    suspend fun addWish(wish: Wish){
        wishDao.addWish(wish)
    }

    fun getWishes() : Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWish(id : Long) : Flow<Wish> = wishDao.getAWish(id)


    suspend fun updateWish(wish: Wish){
        wishDao.updateWish(wish)
    }

    suspend fun deleteWish(wish: Wish){
        wishDao.deleteWish(wish)
    }

}