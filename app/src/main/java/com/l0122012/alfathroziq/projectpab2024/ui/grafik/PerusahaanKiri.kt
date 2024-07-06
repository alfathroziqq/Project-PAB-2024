package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PerusahaanKiri(
    val year: String,
    val company: String,
    val money: String
) : Parcelable