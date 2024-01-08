package com.hanndlee.converter.ui.screens.un_auth

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.foundation.pager.*
import androidx.compose.material3.*
import com.hanndlee.converter.R
import kotlinx.coroutines.launch

data class OnboardingItem(
    val icon: Int,
    val title: String,
    val description: String
)


@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)

val onboardingPages = listOf<OnboardingItem>(
    OnboardingItem(
        icon = R.drawable.onboarding_1,
        title = "Trending Foods",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
    ),
    OnboardingItem(
        icon = R.drawable.onboarding_2,
        title = "Fast Delivery",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
    ),
    OnboardingItem(
        icon = R.drawable.onboarding_3,
        title = "Find Nearby Restaurants",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
    ),
    OnboardingItem(
        icon = R.drawable.onboarding_4,
        title = "Enjoy Ordering",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
    ),
)


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Welcome(navController: NavHostController, sharedPreferences: SharedPreferences) {

    val pagerState = rememberPagerState(
        pageCount = {
            onboardingPages.size
        }
    )

    val coroutineScope = rememberCoroutineScope()



    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Onboarding Pages
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .wrapContentSize()
        ) { page ->
            OnboardingPageView(page = onboardingPages[page], navController = navController)
        }


        // Skip Button
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            if (pagerState.currentPage < onboardingPages.size - 1) {
                // Show the skip button only if not on the last page
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(
                                page = onboardingPages.size - 1
                            )
                        }
                    },
                    modifier = Modifier
                        .background(color = Color.Transparent)
                ) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                }
            }
        }
        // Indicators
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
        ) {
            for (i in onboardingPages.indices) {
                PageIndicator(isActive = i == pagerState.currentPage)
                if (i < onboardingPages.size - 1) {
                    Spacer(modifier = Modifier.width(6.dp))
                }
            }
        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPageView(page: OnboardingItem, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Your custom view for each onboarding page
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 36.dp
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = page.icon),
                contentDescription = "Onboarding Image",
                modifier = Modifier
                    .width(312.dp)
                    .height(312.dp)
            )
            Spacer(modifier = Modifier.height(66.dp))
            Text(text = page.title, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = page.description, style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(32.dp))
            if (
                page.icon == R.drawable.onboarding_4
            ) {
                Button(onClick = {
                    navController.popBackStack()
                    navController.navigate("greeting")
                    onOnboardingFinished(navController.context)
                },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                    Text(
                        text = "Get Started", style = MaterialTheme.typography.titleSmall)
                }
            }

        }
    }


}


@Composable
fun PageIndicator(isActive: Boolean) {
    val color =
        if (isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary.copy(alpha = 0.4f)
    Box(
        modifier = Modifier
            .size(
                height = 8.dp,
                width = if (isActive) 16.dp else 8.dp
            )
            .clip(MaterialTheme.shapes.small)
            .background(color)
    )

}


private fun onOnboardingFinished(context: Context) {
    val sharedPreferences = context.getSharedPreferences("main", Context.MODE_PRIVATE)
    sharedPreferences.edit().putBoolean("isUserDoneOnboarding", true).apply()
}