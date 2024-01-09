package com.hanndlee.converter.ui.screens.auth

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.hanndlee.converter.models.Category
import com.hanndlee.converter.repositories.viewmodels.CategoryViewModel
import com.hanndlee.converter.ui.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    val categoryViewModel: CategoryViewModel = viewModel()

    val viewState by categoryViewModel.categoryState


    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
       when {
           viewState.isLoading-> {
               CircularProgressIndicator(modifier = Modifier
                   .align(Alignment.Center)
                   .fillMaxSize())
           }
           viewState.error != null -> {
               Text(text = viewState.error!!, modifier = Modifier.align(Alignment.Center))
           }
           else -> {
               Column(
                   modifier = Modifier
                       .fillMaxSize(),
                   verticalArrangement = Arrangement.Top,
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {

                   var searchText by remember { mutableStateOf("") }

                   SearchBar(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(8.dp),
                       onSearch = { searchText = it },
                       searchText = searchText
                   )
                   Spacer(modifier = Modifier.height(8.dp))

                   LazyVerticalGrid(
                       modifier = Modifier
                           .fillMaxSize(),
                       userScrollEnabled = true,
                       columns = GridCells.Fixed(2) ,
                   ) {


                       items(
                         viewState.categories.filter {
                               it.strCategory.contains(searchText, ignoreCase = true)
                           }
                       ) { item: Category ->
                           CategoryItem(category = item, navController = navController)
                       }
                   }
               }
           }
       }

    }

}


@Composable
fun CategoryItem(category: Category, navController: NavHostController, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(
                    "detail-category?name=${category.strCategory}&description=${category.strCategoryDescription}&thumbnail=${category.strCategoryThumb}"
                )
            }
            .padding(4.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            AsyncImage(
                model = category.strCategoryThumb,
                contentDescription = "Category Image",
                modifier = Modifier.fillMaxSize()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = category.strCategory, style = MaterialTheme.typography.titleSmall)
        }
    }

}

