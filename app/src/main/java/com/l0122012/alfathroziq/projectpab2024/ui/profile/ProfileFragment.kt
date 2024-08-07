package com.l0122012.alfathroziq.projectpab2024.ui.profile

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.graphics.text.LineBreaker
import android.os.Bundle
import android.text.Html
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
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

        // Mendapatkan referensi Firestore
        val db = Firebase.firestore

        // Mendapatkan container untuk menambahkan judul dan konten
        val sectionsContainer = binding.sectionsContainer

        // Urutan dokumen yang diinginkan
        val orderedSections = listOf("Deskripsi", "Sejarah", "Visi", "Misi", "Tujuan", "Budaya Kerja")

        // Mengambil data dari Firestore
        db.collection("profile").get()
            .addOnSuccessListener { result ->
                val sectionsMap = mutableMapOf<String, String>()

                for (document in result) {
                    val sectionTitle = document.getString("title")
                    val sectionContent = document.getString("content")
                    if (sectionTitle != null && sectionContent != null) {
                        sectionsMap[sectionTitle] = sectionContent
                    }
                }

                // Menambahkan data sesuai urutan yang diinginkan
                for (sectionTitle in orderedSections) {
                    val sectionContent = sectionsMap[sectionTitle]

                    if (sectionContent != null) {
                        val typeface = ResourcesCompat.getFont(requireContext(), R.font.koho)

                        val titleView = TextView(requireContext()).apply {
                            text = sectionTitle
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
                                500, 10
                            ).apply {
                                setMargins(0, 0, 0, 15)
                                gravity = Gravity.CENTER_HORIZONTAL
                            }
                            setLayoutParams(layoutParams)
                        }

                        val contentView = TextView(requireContext()).apply {
                            text = Html.fromHtml(sectionContent)
                            textSize = 17f
                            justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
                            setTypeface(typeface)
                            setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                        }

                        sectionsContainer.addView(titleView)
                        sectionsContainer.addView(lineView)
                        sectionsContainer.addView(contentView)
                    }
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
            }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
