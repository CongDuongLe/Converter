package com.hanndlee.converter.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.hanndlee.converter.ui.theme.Poppins

@Composable
fun AttributedText(inputString: String, keywordActions: Map<String, () -> Unit>) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontFamily = Poppins,
                fontWeight = FontWeight.W400,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        ) {
            append(inputString)
        }

        for ((keyword) in keywordActions) {
            val startIndex = inputString.indexOf(keyword)
            val endIndex = startIndex + keyword.length

            if (startIndex != -1) {
                addStringAnnotation(
                    tag = "ClickableKeyword",
                    annotation = keyword,
                    start = startIndex,
                    end = endIndex
                )

                // Apply a different style to the keywords
                withStyle(style = SpanStyle(color = Color.White)) {
                    addStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W600,
                            fontFamily = Poppins,
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        start = startIndex,
                        end = endIndex
                    )
                }
            }
        }
    }

    ClickableText(
        text = annotatedString,
        modifier = Modifier.fillMaxWidth(),

        onClick = { offset ->
            annotatedString.getStringAnnotations("ClickableKeyword", offset, offset)
                .firstOrNull()?.let { annotation ->
                    // Execute the function associated with the clicked keyword
                    keywordActions[annotation.item]?.invoke()
                }
        }
    )
}