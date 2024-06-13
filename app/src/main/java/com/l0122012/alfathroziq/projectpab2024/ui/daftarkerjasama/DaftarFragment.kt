package com.l0122012.alfathroziq.projectpab2024.ui.daftarkerjasama

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentDaftarBinding

class DaftarFragment : Fragment() {

    private var _binding: FragmentDaftarBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDaftarBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}