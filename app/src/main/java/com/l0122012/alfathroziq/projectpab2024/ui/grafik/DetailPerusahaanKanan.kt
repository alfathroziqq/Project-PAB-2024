package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
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
        val view = binding.root

        fetchDataFromFirebase()

        return view
    }

    private fun fetchDataFromFirebase() {
        val db = FirebaseFirestore.getInstance()
        val collectionPath = "graphic/detailkiri/detailperusahaankanan"

        db.collection(collectionPath)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val year = document.getString("year") ?: ""
                    val company = document.getString("company") ?: ""
                    val description = document.getString("description") ?: ""
                    val perusahaan = Perusahaan(year, company, description)
                    list.add(perusahaan)
                }
                showRecyclerList()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPerusahaan = binding.rvPerusahaan
        rvPerusahaan.setHasFixedSize(true)

        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvPerusahaan.layoutManager = LinearLayoutManager(context)
        val listPerusahaanAdapter = ListPerusahaanAdapter(list) { perusahaan ->
            val action = DetailPerusahaanKananDirections.actionDetailPerusahaanKananToDetailRinciFragment(
                perusahaan.year, perusahaan.company, perusahaan.description
            )
            findNavController().navigate(action)
        }
        rvPerusahaan.adapter = listPerusahaanAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
