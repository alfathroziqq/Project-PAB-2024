package com.l0122012.alfathroziq.projectpab2024.ui.profile

import android.os.Bundle

class IntentProfile {
    fun getProfileBundle(): Bundle {
        val profileBundle = Bundle()
        profileBundle.putString(ProfileFragment.EXTRA_NAME, "Kelompok 6")
        profileBundle.putString(ProfileFragment.EXTRA_NIM, "L0122000")
        profileBundle.putString(ProfileFragment.EXTRA_PRODI, "Informatika")
        profileBundle.putInt(ProfileFragment.EXTRA_BATCH, 2022)
        profileBundle.putString(ProfileFragment.EXTRA_FACULTY, "FATISDA")
        profileBundle.putString(ProfileFragment.EXTRA_UNIVERSITY, "Universitas Sebelas Maret")
        profileBundle.putString(ProfileFragment.EXTRA_EMAIL, "kelompok6@gmail.com")
        return profileBundle
    }
}
