package com.example.android_development.ui.theme

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.android_development.R

@Composable
fun AppBarView(
    title : String,
    onbacknavclick : () -> Unit = {}
){
    val navigationIcon : (@Composable () -> Unit)? =
        if(!title.contains("WishList")){
            {
            IconButton(onClick = { onbacknavclick() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    tint = Color.Black,
                    contentDescription =null
                )
            }
        }
        }
    else{
        null
        }
    TopAppBar(title = {
        Text(text = title,
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .padding(start = 4.dp)
                .height(24.dp))
    },
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.purple_500)
    )
}