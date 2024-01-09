package com.hanndlee.converter.repositories.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hanndlee.converter.models.Category
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.hanndlee.converter.utils.retrofit.RetrofitInstance
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {

    private val _categoryState = mutableStateOf(CategoryState())

    val categoryState: State<CategoryState> = _categoryState

    init {
        fetchCategory()
    }

    private fun fetchCategory() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.apiService.getCategories()

                Log.i("Response", "fetchCategory: ${response.body()!!.categories}")

                if (response.isSuccessful) {
                    _categoryState.value = _categoryState.value.copy(
                        isLoading = false,
                        categories = response.body()!!.categories,
                        error = null
                    )
                }

            } catch (e: Exception) {
                Log.d("CategoryViewModel", "fetchCategory: ${e.message}")
                _categoryState.value = _categoryState.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }


    data class CategoryState(
        val isLoading: Boolean = false,
        val categories: List<Category> = emptyList(),
        val error: String? = null
    )


}