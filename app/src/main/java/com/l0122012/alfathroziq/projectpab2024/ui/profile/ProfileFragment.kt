package com.l0122012.alfathroziq.projectpab2024.ui.profile

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.graphics.text.LineBreaker
import android.os.Bundle
import android.text.Html
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.l0122012.alfathroziq.projectpab2024.R
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        // Mendapatkan array judul dan konten dari resources
        val sectionTitles = resources.getStringArray(R.array.judul_profile)
        val sectionContents = resources.getStringArray(R.array.detail_profile)

        // Mendapatkan container untuk menambahkan judul dan konten
        val sectionsContainer = binding.sectionsContainer

        // Menambahkan judul dan konten ke dalam container
        for (i in sectionTitles.indices) {
            val typeface = ResourcesCompat.getFont(requireContext(), R.font.koho)

            val titleView = TextView(requireContext()).apply {
                text = sectionTitles[i]
                textSize = 20f
                setPadding(0, 0, 0, 10)
                gravity = Gravity.CENTER_HORIZONTAL
                setTypeface(typeface, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            }

            val lineDrawable = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                setColor(Color.BLACK)
                cornerRadius = 10f
            }

            val lineView = View(requireContext()).apply {
                background = lineDrawable
                val layoutParams = LinearLayout.LayoutParams(
                    500,10
                ).apply {
                    setMargins(0, 0, 0, 15)
                    gravity = Gravity.CENTER_HORIZONTAL
                }
                setLayoutParams(layoutParams)
            }

            val contentView = TextView(requireContext()).apply {
                text = Html.fromHtml(sectionContents[i])
                textSize = 17f
                justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
                setTypeface(typeface, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            }

            sectionsContainer.addView(titleView)
            sectionsContainer.addView(lineView)
            sectionsContainer.addView(contentView)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
