package com.example.recyclerview

import androidx.annotation.DrawableRes

data class Contact(
    val name: String,
    val contact: String,
    @DrawableRes val icon: Int
)
