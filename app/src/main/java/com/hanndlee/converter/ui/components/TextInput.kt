package com.hanndlee.converter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.hanndlee.converter.ui.theme.gray50

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    placeholder: String? = null,
    visualTransformation: VisualTransformation? = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
) {

    val keyboardController = LocalSoftwareKeyboardController.current


    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        if (label != null){
            Text(text = label ?: "")
            Spacer(modifier = Modifier.height(8.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .border(1.dp,
                    // darktheme is white and lighttheme is black
                    MaterialTheme.colorScheme.onSurface,
                    RoundedCornerShape(100.dp))
        ) {
            if (visualTransformation != null) {
                TextField(
                    value = value,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    onValueChange = onValueChange,
                    placeholder = {
                        Text(
                            text = placeholder ?: "",
                            color = gray50,
                            style = MaterialTheme.typography.labelSmall
                        )
                    },
                    visualTransformation = visualTransformation,
                    trailingIcon = trailingIcon,
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.onSurface,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    ),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    textStyle = MaterialTheme.typography.displaySmall
                )
            }
        }
    }


}