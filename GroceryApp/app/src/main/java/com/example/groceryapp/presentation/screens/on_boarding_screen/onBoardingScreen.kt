package com.example.groceryapp.presentation.screens.on_boarding_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.groceryapp.R
import com.example.groceryapp.presentation.common.VerticalSpacer
import com.example.groceryapp.ui.theme.GroceryAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun onBoardingScreen(
    // navController: NavHostController
) {
//    val compotionResult: LottieCompositionResult = rememberLottieComposition(
//        spec = LottieCompositionSpec.RawRes(R.raw.lottie1)
//    )

//    val compositions =
//        listOf(
//            rememberLottieComposition(
//                spec = LottieCompositionSpec.RawRes(R.raw.lottie1)
//            ),
//            rememberLottieComposition(
//                spec = LottieCompositionSpec.RawRes(R.raw.shopping_bag)
//            ),
//            rememberLottieComposition(
//                spec = LottieCompositionSpec.RawRes(R.raw.cart)
//            )
//        )



    val pagerState = rememberPagerState()
    val list = listOf("vaibhav", "Siddhant", "Amod")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(10.dp)
    ) {
        
        VerticalSpacer(height = 30)
        Box(
            modifier = Modifier
                .fillMaxHeight(0.85f)
                .fillMaxWidth()
        ) {
            HorizontalPager(
                count = list.size,
                state = pagerState,
                verticalAlignment = Alignment.CenterVertically
            ) { currentPage ->

                val animation = rememberLottieComposition(
                    spec = LottieCompositionSpec.RawRes(animationList[currentPage].animationId)
                )

                val progressAnimation by animateLottieCompositionAsState(
                    animation.value,
                    isPlaying = true,
                    iterations = LottieConstants.IterateForever,
                    speed = 1.0f
                )


                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = animationList[currentPage].description,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(12.dp),
                        textAlign = TextAlign.Center
                    )

                    LottieAnimation(
                        modifier = Modifier.height(500.dp),
                        composition = animation.value,
                        progress = progressAnimation
                    )
                }
            }
        }

        Indicator(pageCount = list.size, pagerState = pagerState)

        if (pagerState.currentPage == animationList.lastIndex) {
            Button(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 20.dp, bottom = 10.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.yellow)
                )
                ) {
                Text(text = "login")
            }
        }


    }
}

@Preview(showSystemUi = true)
@Composable
fun OnBoardingScreenPreview() {
    GroceryAppTheme {
        onBoardingScreen()
    }
}