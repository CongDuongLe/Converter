package com.hanndlee.converter.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage


@Composable
fun DetailCategory(
    navController: NavController,
    name: String?,
    description: String?,
    thumbnail: String?
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (thumbnail != null) {
            AsyncImage(model = thumbnail, contentDescription = "Category thumbnail")
        }
        Spacer(modifier = Modifier.height(16.dp))

        if (name != null) {
            Text(text = name, style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (description != null) {
            Text(text = description, style = MaterialTheme.typography.bodySmall)
        }


    }


}