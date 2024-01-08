package com.hanndlee.converter.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


enum class ButtonType {
    PRIMARY,
    SECONDARY}



@Composable
fun LoginButton(
    onPress : () -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    type : ButtonType = ButtonType.PRIMARY,
    enable : Boolean = true
) {

    val buttonColors = when (type) {
        ButtonType.PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = if (enable) MaterialTheme.colorScheme.primary else Color.Gray,
            contentColor = Color.Black
        )
        ButtonType.SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = if (enable) Color.White else Color.Gray,
            contentColor = Color.Black
        )
    }


    val borderWidth = 1.dp
    val borderColor = if (enable){
        if (type == ButtonType.PRIMARY) MaterialTheme.colorScheme.primary else Color.Black
    } else {
        Color.Gray
    }

    Button(
        onClick = { onPress() },
        modifier = modifier.fillMaxWidth().height(54.dp),
        shape = MaterialTheme.shapes.extraLarge,
        colors = buttonColors,
        border = BorderStroke(borderWidth, borderColor),
        enabled = enable
    ) {
        Text(text = title, style = MaterialTheme.typography.titleSmall)
    }
}