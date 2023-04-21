package com.example.groceryapp.presentation.screens.on_boarding_screen

import androidx.annotation.RawRes
import com.example.groceryapp.R


data class Animation(
    val description: String,
    @RawRes val animationId: Int,
)


val animationList = listOf(
    Animation(
    description = "Your one stop solution \n  for all groceries",
    animationId = R.raw.lottie1
    ),
    Animation(
        description = "Place order from the comfort \n of your home",
        animationId = R.raw.ecommerce
    ),
    Animation(
        description = "Pickup anytime from \n our shop",
        animationId = R.raw.shopping_bag
    )
)
