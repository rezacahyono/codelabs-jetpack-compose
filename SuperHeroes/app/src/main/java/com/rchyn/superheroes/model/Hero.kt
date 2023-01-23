package com.rchyn.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @DrawableRes
    val imageRes: Int,
    @StringRes
    val titleRes: Int,
    @StringRes
    val descriptionRes: Int
)
