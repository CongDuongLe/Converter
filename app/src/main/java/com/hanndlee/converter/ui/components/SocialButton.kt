package com.hanndlee.converter.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable

fun SocialButton(
    modifier: Modifier = Modifier,
    onPress: () -> Unit,
    title: String,
    icon : Int? = null,
    enable : Boolean = true
) {
    Button(
        onClick = onPress,
        enabled = enable,
        modifier = modifier
            .fillMaxWidth().height(54.dp),
        shape = MaterialTheme.shapes.extraLarge,
        border = BorderStroke(1.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            if (icon != null) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}