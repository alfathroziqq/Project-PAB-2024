package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentDetailRinciBinding

class DetailRinciFragment : Fragment() {
    private var _binding: FragmentDetailRinciBinding? = null
    private val binding get() = _binding!!

    private var year: String? = null
    private var company: String? = null
    private var description: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            year = it.getString("year")
            company = it.getString("company")
            description = it.getString("description")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailRinciBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvItemYear.text = year
        binding.tvItemCompany.text = company
        binding.tvItemDescription.text = description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
