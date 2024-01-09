package com.hanndlee.converter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable

fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit,
    searchText: String = ""
) {


// Get the keyboard controller
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .border(
                1.dp,
                // darktheme is white and lighttheme is black
                MaterialTheme.colorScheme.onSurface,
                RoundedCornerShape(100.dp)
            )
    ) {

        TextField(
            value = searchText,
            onValueChange = {
                // Update the search text when the user types
                onSearch(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .padding(horizontal = 8.dp),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    // Handle search button click
                    onSearch(searchText)
                    // Hide the keyboard
                    keyboardController?.hide()
                }
            ),
            placeholder = { Text("Search...", style = MaterialTheme.typography.labelMedium) },
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedLabelColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.onSurface,
            ),
            textStyle = MaterialTheme.typography.labelMedium
        )
    }

    // Search input field

}