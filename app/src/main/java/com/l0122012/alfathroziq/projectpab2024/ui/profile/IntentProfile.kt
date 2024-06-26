package com.l0122012.alfathroziq.projectpab2024.ui.profile

import android.os.Bundle

class IntentProfile {
    fun getProfileBundle(): Bundle {
        val profileBundle = Bundle()
        profileBundle.putString(ProfileFragment.EXTRA_NAME, "UNIVERSITAS SEBELAS MARET")
        return profileBundle
    }
}
