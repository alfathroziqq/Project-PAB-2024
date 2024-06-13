package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentGrafikKiriBinding

class GrafikKiriFragment : Fragment() {
    private var _binding: FragmentGrafikKiriBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGrafikKiriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            barChartVer.animation.duration = ANIMATION_DURATION
            barChartVer.animate(barSet)
        }
    }

    companion object {
        private val barSet = listOf(
            "JAN" to 2F,
            "FEB" to 3F,
            "MAR" to 4F,
            "APR" to 5F,
            "MAY" to 6F,
            "JUN" to 7F,
            "JUL" to 8F
        )

        private const val ANIMATION_DURATION = 1000L
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
