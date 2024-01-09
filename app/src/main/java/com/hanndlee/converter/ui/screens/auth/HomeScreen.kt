package com.hanndlee.converter.ui.screens.auth

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.hanndlee.converter.models.Category
import com.hanndlee.converter.ui.components.SearchBar
import com.hanndlee.converter.utils.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    var listCategory by remember {
        mutableStateOf(listOf<Category>())
    }
    val context = LocalContext.current


    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        scope.launch(Dispatchers.IO) {
            val res = try {
                RetrofitInstance.apiService.getCategories()
            } catch (e: IOException) {
                Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                return@launch
            } catch (e: HttpException) {
                Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                return@launch
            }
            if (res.isSuccessful && res.body() != null) {
                withContext(Dispatchers.Main) {
                    listCategory = res.body()!!.categories
                }
            } else {
                Toast.makeText(context, "Error: ${res.code()}", Toast.LENGTH_SHORT).show()
            }


        }
    }

    val scrollState = rememberLazyStaggeredGridState()

    var searchText by remember {
        mutableStateOf("")
    }
    val isScrolled by remember {
        derivedStateOf {
            scrollState.firstVisibleItemScrollOffset != 0
        }
    }


    Scaffold(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        topBar = {
            AnimatedVisibility(
                visible = isScrolled,
                exit = slideOutVertically() + fadeOut(),
                enter = slideInVertically() + fadeIn()
            ) {
                SearchBar(
                    onSearch = {
                        searchText = it
                    },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    searchText = searchText,
                )
            }
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = if (!isScrolled) 0.dp else paddingValues.calculateTopPadding()

                    )
            ) {
                LazyVerticalStaggeredGrid(
                    modifier = Modifier.fillMaxSize(),
                    state = scrollState,
                    columns = StaggeredGridCells.Fixed(2),
                ) {
                    items(listCategory.filter {
                        it.strCategory.contains(searchText, ignoreCase = true)
                    }) { category ->
                        CategoryItem(
                            category = category,
                            navController = navController,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        )
                    }
                }
            }
        }
    )


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

