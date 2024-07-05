package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.projectpab2024.R
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentDetailKeuanganKiriBinding

class DetailKeuanganKiri : Fragment() {
    private var _binding: FragmentDetailKeuanganKiriBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvKeuangan: RecyclerView
    private val list = ArrayList<Keuangan>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailKeuanganKiriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvKeuangan = view.findViewById(R.id.rv_keuangan)
        rvKeuangan.setHasFixedSize(true)

        list.addAll(getListKeuangan())
        showRecyclerList()
    }

    fun getListKeuangan(): ArrayList<Keuangan> {
        val dataYear = resources.getStringArray(R.array.data_year)
        val dataMoney = resources.getStringArray(R.array.data_money)
        val dataCate = resources.getStringArray(R.array.data_cate)
        val listKeuangan = ArrayList<Keuangan>()
        for (i in dataYear.indices) {
            val year = dataYear[i]
            val money = dataMoney[i].toInt()
            val category = dataCate[i]
            val keuangan = Keuangan(year, money, category)
            listKeuangan.add(keuangan)
        }
        return listKeuangan
    }

    private fun showRecyclerList() {
        rvKeuangan.layoutManager = LinearLayoutManager(context)
        val listKeuanganAdapter = ListKeuanganAdapter(list)
        rvKeuangan.adapter = listKeuanganAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
