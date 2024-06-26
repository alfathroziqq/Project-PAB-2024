package com.l0122012.alfathroziq.projectpab2024.ui.home

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val imageResId: Int,
    val title: String,
    val detail: String
) : Parcelable
