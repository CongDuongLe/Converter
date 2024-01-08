package com.hanndlee.converter.ui.screens.un_auth

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hanndlee.converter.R
import com.hanndlee.converter.ui.components.AttributedText
import com.hanndlee.converter.ui.components.ButtonType
import com.hanndlee.converter.ui.components.LoginButton

@Composable
fun Greeting(navController: NavHostController, sharedPreferences: SharedPreferences) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 26.dp, vertical = 32.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.onboarding_5),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    ,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Welcome to Super Shy", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Lorem ipsum dolor sit amet consectetur. Ut cras pellentesque", style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(32.dp))
                LoginButton(
                    onPress = {
                        navController.navigate("register")
                    },
                    title = "Create Account",
                    type = ButtonType.PRIMARY
                )
                Spacer(modifier = Modifier.height(12.dp))
                LoginButton(
                    onPress = {
                        navController.navigate("login")
                    },
                    title = "Login",
                    type = ButtonType.SECONDARY
                )
                 Spacer(modifier = Modifier.height(32.dp))



            }

            // AttributedText(inputString = inputString, keywordActions = attributedKeys)
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                val inputString = "By Registering or Login you have agreed to these Terms and Conditions."
                val attributedKeys = mapOf(
                    "Terms and Conditions" to {
                        navController.navigate("terms-and-conditions")
                    },
                    "Registering" to {
                        navController.navigate("register")
                    },
                    "Login" to {
                        navController.navigate("login")
                    }
                )

                AttributedText(inputString = inputString, keywordActions = attributedKeys)
            }



        }








    }
}