package com.example.restaurantapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.pizzaapp.R


data class Restaurant(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val preview: Int,
    @StringRes val description: Int
)

val restaurants: List<Restaurant> = listOf(
    Restaurant(R.drawable.sushi_restaurant, R.string.japanese_food, R.string.sushi_prev, R.string.sushi_Description),
    Restaurant(R.drawable.mexican_restaurant, R.string.mexican_food, R.string.sushi_prev, R.string.mexican_Description),
    Restaurant(R.drawable.italian_restaurant, R.string.italian_food, R.string.sushi_prev, R.string.italian_Description),
    Restaurant(R.drawable.indian_restaurant, R.string.libanese_food, R.string.sushi_prev, R.string.indian_Description),
    Restaurant(R.drawable.usa_restaurant, R.string.usa_food, R.string.sushi_prev, R.string.usa_Description),
    Restaurant(R.drawable.china_restaurant, R.string.chinese_food, R.string.sushi_prev, R.string.china_Description),
)
