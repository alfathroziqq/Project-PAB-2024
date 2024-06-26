package com.l0122012.alfathroziq.projectpab2024.ui.profile

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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

        // Mendapatkan bundle profil dari arguments
        val profileBundle = arguments?.getBundle("profileBundle")
        val name = profileBundle?.getString(EXTRA_NAME)

        // Menampilkan nama di TextView
        val text = "Name: $name"
        binding.tvProfileData.text = text

        // Mendapatkan array judul dan konten dari resources
        val sectionTitles = resources.getStringArray(R.array.judul_profile)
        val sectionContents = resources.getStringArray(R.array.detail_profile)

        // Mendapatkan container untuk menambahkan judul dan konten
        val sectionsContainer = binding.sectionsContainer

        // Menambahkan judul dan konten ke dalam container
        for (i in sectionTitles.indices) {
            val titleView = TextView(requireContext())
            titleView.text = sectionTitles[i]
            titleView.textSize = 20f
            titleView.setPadding(10, 10, 10, 10)

            val contentView = TextView(requireContext())
            contentView.text = Html.fromHtml(sectionContents[i])
            contentView.textSize = 16f
            contentView.setPadding(10, 10, 10, 10)

            sectionsContainer.addView(titleView)
            sectionsContainer.addView(contentView)
        }

        // Mendapatkan tombol Share dan menambahkan onClickListener
        val buttonShare = binding.buttonShare
        buttonShare.setOnClickListener {
            shareProfileInfo(profileBundle)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun shareProfileInfo(profileBundle: Bundle?) {
        // Implementasi untuk berbagi informasi profil
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        // Tambahkan konstanta-konstanta lainnya seperti EXTRA_PRODI, EXTRA_BATCH, dsb. sesuai kebutuhan
    }
}
