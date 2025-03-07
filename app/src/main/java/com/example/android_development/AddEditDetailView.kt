package com.example.android_development

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.android_development.ui.theme.AppBarView

@Composable
fun AddEditDetailView(
    id : Long,
    viewModel: WishViewModel,
    navController: NavController
){
    Scaffold (
        topBar = {
            AppBarView(title =
            if(id!=0L) stringResource(id = R.string.update_wish)
            else stringResource(id = R.string.add_wish)
            ){navController.navigateUp()}
                 },
        ){
        Column(modifier = Modifier.padding(it).wrapContentSize(),
               horizontalAlignment =Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            
            wishtextfield(label = "Title",
                value = viewModel.wishTitleState,
                onvaluechange = {
                    viewModel.onWishTitleChanged(it)
                })

            Spacer(modifier = Modifier.height(10.dp))

            wishtextfield(label = "Description",
                value = viewModel.wishDescriptionState,
                onvaluechange = {
                    viewModel.onWishDescriptionChange(it)
                })

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                if(viewModel.wishTitleState.isNotEmpty()  &&  viewModel.wishDescriptionState.isNotEmpty()){
                     // TODO UpdateWish
                }else{
                    // TODO AddWish
                }
            }) {
                Text(
                    text = if(id!=0L) stringResource(id = R.string.update_wish)
                           else stringResource(id = R.string.add_wish),
                style = TextStyle(fontSize = 18.sp)

                )
            }


        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun wishtextfield(
    label : String,
    value : String,
    onvaluechange : (String) -> Unit
){
    OutlinedTextField(value = value,
        onValueChange = onvaluechange,
        label = { Text(text = label,color = Color.Black) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
           // textColor = Color.Black,
           focusedBorderColor = colorResource(id = R.color.black),
           unfocusedBorderColor  =  colorResource(id = R.color.black),
           cursorColor = colorResource(id = R.color.black),
           focusedLabelColor = colorResource(id = R.color.black),
           unfocusedLabelColor = colorResource(id = R.color.black)

        )
    )
}

@Preview
@Composable
fun wishlistpreveiw(){
    wishtextfield(label = "text", value = " text" , onvaluechange = {})
    }