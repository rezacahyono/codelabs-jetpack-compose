package com.rchyn.buildagrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes
    val title: Int,
    val total: Int,
    @DrawableRes
    val image: Int
)