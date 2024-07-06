package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.l0122012.alfathroziq.projectpab2024.R
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentDetailPerusahaanKiriBinding

class DetailPerusahaanKiri : Fragment() {
    private var _binding: FragmentDetailPerusahaanKiriBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvPerusahaanKiri: RecyclerView
    private val list = ArrayList<PerusahaanKiri>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailPerusahaanKiriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPerusahaanKiri = view.findViewById(R.id.rv_perusahaan_kiri)
        rvPerusahaanKiri.setHasFixedSize(true)

        fetchPerusahaanKiriData()
    }

    private fun fetchPerusahaanKiriData() {
        val db = FirebaseFirestore.getInstance()
        val collectionPath = "graphic/detailkiri/detailperusahaankiri"

        db.collection(collectionPath)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val year = document.getString("year") ?: ""
                    val company = document.getString("company") ?: ""
                    val money = document.getString("money") ?: ""
                    val perusahaankiri = PerusahaanKiri(year, company, money)
                    list.add(perusahaankiri)
                }
                showRecyclerList()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showRecyclerList() {
        rvPerusahaanKiri.layoutManager = LinearLayoutManager(context)
        val listPerusahaanKiriAdapter = ListPerusahaanKiriAdapter(list)
        rvPerusahaanKiri.adapter = listPerusahaanKiriAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
