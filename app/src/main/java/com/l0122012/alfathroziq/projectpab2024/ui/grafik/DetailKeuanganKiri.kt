package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
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

        fetchKeuanganData()
    }

    private fun fetchKeuanganData() {
        val db = FirebaseFirestore.getInstance()
        val collectionPath = "graphic/detailkiri/detailkeuangankiri"

        db.collection(collectionPath)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val year = document.getString("year")?: ""
                    val money = document.getString("money") ?: ""
                    val cate = document.getString("cate") ?: ""
                    val keuangan = Keuangan(year, money, cate)
                    list.add(keuangan)
                }
                showRecyclerList()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
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
