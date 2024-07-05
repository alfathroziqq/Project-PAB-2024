package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Keuangan(
    val year: String,
    val money: Int,
    val cate: String
) : Parcelable