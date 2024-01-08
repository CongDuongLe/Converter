package com.hanndlee.converter.ui.screens.un_auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hanndlee.converter.R
import com.hanndlee.converter.ui.components.AttributedText
import com.hanndlee.converter.ui.components.LoginButton
import com.hanndlee.converter.ui.components.SocialButton
import com.hanndlee.converter.ui.components.TextInput
import com.hanndlee.converter.utils.helper.isValidEmail
import com.hanndlee.converter.utils.helper.isValidPassword

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Login(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 26.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var isShowPassword by remember { mutableStateOf(false) }

            // Logo
            Image(
                painter = painterResource(id = R.drawable.ic_brand_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(150.dp)
                    .height(110.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            // Textinput
            Spacer(modifier = Modifier.height(8.dp))
            TextInput(
                value = email,
                onValueChange = { email = it },
                placeholder = "Enter your email",
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextInput(
                value = password,
                onValueChange = { password = it },
                placeholder = "Enter your password",
                visualTransformation = if (isShowPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = if (isShowPassword) R.drawable.eye else R.drawable.eye_slash),
                        contentDescription = "eye",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                isShowPassword = !isShowPassword
                            }
                            .padding(
                                end = 2.dp
                            )
                    )
                }
            )
            // Forgot Password
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Text(
                    text = "Forgot Password?",
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .clickable {
                            navController.navigate("forgot-password")
                        }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Login Button
            LoginButton(
                onPress = {
                    navController.navigate("home")
                },
                title = "Login",
                enable = isValidEmail(email) && isValidPassword(password)
            )
            Spacer(modifier = Modifier.height(32.dp))
            SeparateOr(
                text = "OR"
            )
            Spacer(modifier = Modifier.height(32.dp))
            // Social Login
            SocialButton(
                onPress = { },
                title = "Login with Google",
                icon = R.drawable.ic_google_color,
                enable = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            SocialButton(
                onPress = { },
                title = "Login with Facebook",
                icon = R.drawable.ic_facebook,
                enable = true
            )

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            AttributedText(inputString = "Don’t have an account? Sign up", keywordActions = mapOf(
                "Sign up" to {
                    navController.navigate("register")
                }
            ))
        }

    }
}


@Composable
fun SeparateOr(text: String? = "OR") {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // Line
        Image(
            painter = painterResource(id = R.drawable.ic_line_separator),
            contentDescription = "separtor left",
            contentScale = ContentScale.None
        )
        Spacer(modifier = Modifier.width(18.dp))
        // Text
        if (text != null) {
            Text(text = text, style = MaterialTheme.typography.labelSmall)
            Spacer(modifier = Modifier.width(18.dp))
            // Line
            Image(
                painter = painterResource(id = R.drawable.ic_line_separator),
                contentDescription = "separtor right",
                contentScale = ContentScale.None
            )
        }
    }
}