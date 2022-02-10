package com.example.compose.common.model

import androidx.annotation.DrawableRes

data class Coin(
    val id: String,
    val ticker: String,
    @DrawableRes val iconRes: Int,
    val name: String,
    val price: String,
    val isChecked: Boolean
)