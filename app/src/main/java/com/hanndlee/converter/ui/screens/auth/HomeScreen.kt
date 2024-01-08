package com.hanndlee.converter.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hanndlee.converter.utils.constants.listCoffee

@Composable
fun HomeScreen(navController: NavHostController) {

    var listCoffee by remember { mutableStateOf(listCoffee) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp,
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Screen")
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(){
          items(listCoffee){
              item -> Text(text = item.name)
          }
        }



    }
}