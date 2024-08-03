package com.example.android_development.wishlist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo


@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    @ColumnInfo(name = "wish-title")
    val description : String = "",
    @ColumnInfo(name = "wish-desc")
    val title : String = ""
)

object dummywishes{
    val wishlist = listOf(
        Wish(title = "Google Watch", description = "Android Watch"),
        Wish(title = "India", description = "First in population"),
        Wish(title = "Churu", description = "Records highest temperature in summer")
    )
}
