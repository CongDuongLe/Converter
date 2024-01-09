package com.hanndlee.converter.ui.navigation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hanndlee.converter.ui.screens.auth.DetailCategory
import com.hanndlee.converter.ui.screens.auth.HomeScreen
import com.hanndlee.converter.ui.screens.un_auth.*


@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun RootNavigator() {

    val navController = rememberNavController()
    val context = LocalContext.current

    val sharedPreferences = context.getSharedPreferences("main", Context.MODE_PRIVATE)

    val isUserLoggedIn = sharedPreferences.getBoolean("isUserLoggedIn", true)

    val isUserDoneOnboarding = sharedPreferences.getBoolean("isUserDoneOnboarding", false)


    NavHost(
        navController = navController, startDestination = if (isUserDoneOnboarding) {
            if (isUserLoggedIn) {
                "home"
            } else {
                "greeting"
            }
        } else {
            "welcome"
        }
    ) {
        // unauthorized
        composable("welcome") {
            Welcome(navController = navController, sharedPreferences = sharedPreferences)
        }
        composable("login") {
            Login(navController = navController)
        }
        composable("register") {
            Register(navController = navController)
        }
        composable("forgot-password") {
            ForgotPassword(navController = navController)
        }

        composable("greeting") {
            Greeting(navController = navController, sharedPreferences = sharedPreferences)
        }

        // authorized
        composable("home") {
            HomeScreen(navController = navController)
        }

        composable(
            "detail-category?name={name}&description={description}&thumbnail={thumbnail}",

            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("description") {
                    type = NavType.StringType
                },
                navArgument("thumbnail") {
                    type = NavType.StringType
                },
            )


        ) {

            DetailCategory(
                navController = navController,
                name = it.arguments?.getString("name"),
                description = it.arguments?.getString("description"),
                thumbnail = it.arguments?.getString("thumbnail")
            )
        }


    }
}




