package com.hanndlee.converter.ui.screens.un_auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hanndlee.converter.ui.components.AttributedText
import com.hanndlee.converter.ui.components.LoginButton
import com.hanndlee.converter.ui.components.TextInput
import com.hanndlee.converter.utils.helper.isValidEmail

@Composable
fun ForgotPassword(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {


            var email by remember { mutableStateOf("") }


            Text(text = "Forgot Password", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Start)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Enter your registered email below",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(64.dp))
            TextInput(
                value = email,
                onValueChange = { email = it },
                placeholder = "Enter your email",
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
            AttributedText(
                inputString = "Remember the password? Login",
                keywordActions = mapOf(
                    "Login" to { navController.navigate("login") }
                )
            )
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.4f))
            LoginButton(
                onPress = {},
                title = "Submit",
                enable = isValidEmail(email)
            )
        }
    }
}