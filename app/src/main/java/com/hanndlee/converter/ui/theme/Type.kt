package com.hanndlee.converter.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hanndlee.converter.R

// Set of Material typography styles to start with

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
)



val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = (-0.44).sp,
        color = Color.Black
    ),
    titleMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = (-0.408).sp,
        color = Color.Black
    ),
    titleSmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.352).sp,
        color = Color.Black
    ),
    bodyLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        fontSize = 26.sp,
        lineHeight = 39.sp,
        letterSpacing = (-0.572).sp,
        color = Color.Black
    ),
    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        letterSpacing = (-0.528).sp,
        color = Color.Black
    ),
    bodySmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W400,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.286).sp,
        color = Color.Black
    ),
    labelMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.352).sp,
        color = Color.Black
    ),
    labelSmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        fontSize = 15.sp,
        color = Color.Black
    ),
    displaySmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp,
        letterSpacing = (-0.286).sp,
        color = Color.Black
    ),


)