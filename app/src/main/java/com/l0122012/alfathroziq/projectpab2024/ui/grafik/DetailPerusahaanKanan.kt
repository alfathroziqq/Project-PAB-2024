package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.projectpab2024.R
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentDetailPerusahaanKananBinding

class DetailPerusahaanKanan : Fragment() {
    private var _binding: FragmentDetailPerusahaanKananBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvPerusahaan: RecyclerView
    private val list = ArrayList<Perusahaan>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailPerusahaanKananBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPerusahaan = view.findViewById(R.id.rv_perusahaan)
        rvPerusahaan.setHasFixedSize(true)

        list.addAll(getListPerusahaan())
        showRecyclerList()
    }

    fun getListPerusahaan(): ArrayList<Perusahaan> {
        val dataYear = resources.getStringArray(R.array.data_yearperu)
        val dataCompany = resources.getStringArray(R.array.data_company)
        val dataMoney = resources.getStringArray(R.array.data_moneyperu)
        val listPerusahaan = ArrayList<Perusahaan>()
        for (i in dataYear.indices) {
            val year = dataYear[i]
            val company = dataCompany[i]
            val money = dataMoney[i].toInt()
            val perusahaan = Perusahaan(year, company, money)
            listPerusahaan.add(perusahaan)
        }
        return listPerusahaan
    }

    private fun showRecyclerList() {
        rvPerusahaan.layoutManager = LinearLayoutManager(context)
        val listPerusahaanAdapter = ListPerusahaanAdapter(list)
        rvPerusahaan.adapter = listPerusahaanAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}