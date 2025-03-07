package com.example.android_development.ui.theme

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android_development.R
import com.example.android_development.Screen
import com.example.android_development.WishViewModel
import com.example.android_development.wishlist.data.Wish
import com.example.android_development.wishlist.data.dummywishes

@Composable
fun HomeView(
    navController : NavController,
    viewModel: WishViewModel
){
    val context = LocalContext.current
    Scaffold(
        topBar = {AppBarView(title = "WishList",
            {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
                 })},

            floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(20.dp),
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.purple_500),
                onClick = { Toast.makeText(context, " fab Button Clicked", Toast.LENGTH_LONG).show()
                navController.navigate(Screen.AddScreen.route)
                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null )
            }
        }
    ) {
        LazyColumn (modifier = Modifier.fillMaxSize().padding(it)){
            items(dummywishes.wishlist){
                wish -> WishItem(wish = wish) {

            }
            }

        }
    }
}

@Composable
fun WishItem(wish: Wish,onClick : () -> Unit){
    Card(modifier = Modifier.fillMaxWidth().padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable {
            onClick()
        },
        elevation = 10.dp,
        backgroundColor = colorResource(id = R.color.white)
        ) {

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }
        
    }
}