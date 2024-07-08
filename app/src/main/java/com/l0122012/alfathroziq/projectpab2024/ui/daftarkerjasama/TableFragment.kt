package com.l0122012.alfathroziq.projectpab2024.ui.daftarkerjasama

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.widget.SearchView
import com.google.firebase.firestore.FirebaseFirestore
import com.l0122012.alfathroziq.projectpab2024.R
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentTableBinding

class TableFragment : Fragment() {

    private lateinit var binding: FragmentTableBinding
    private lateinit var adapter: TableAdapter
    private val data = mutableListOf<Array<String>>()
    private lateinit var tableName: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTableBinding.inflate(inflater, container, false)
        val view = binding.root

        // Ambil argument tableName dari bundle
        val args = TableFragmentArgs.fromBundle(requireArguments())
        tableName = args.tableName

        // Setup RecyclerView
        adapter = TableAdapter(data)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // Inflate header and add to layout
        val headerView = inflater.inflate(R.layout.item_header_kerjasama, binding.headerContainer, false)
        binding.headerContainer.addView(headerView)

        // Set up search functionality
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    adapter.filter(newText)
                }
                return false
            }
        })

        // Fetch data from Firestore
        fetchTableData()

        return view
    }

    private fun fetchTableData() {
        val db = FirebaseFirestore.getInstance()
        db.collection("kerjasama").document("daftar").collection(tableName)
            .get()
            .addOnSuccessListener { result ->
                data.clear()
                for (document in result) {
                    val nomor = document.getString("No") ?: ""
                    val namaKerjasama = document.getString("Nama Mitra") ?: ""
                    val tanggal = document.getString("Tanggal Mulai - Selesai") ?: ""
                    val nominal = document.getString("Nominal") ?: ""
                    data.add(arrayOf(nomor, namaKerjasama, tanggal, nominal))
                }
                adapter.setData(data) // Panggil metode baru untuk mengatur data dan memfilter seluruh data
                adapter.notifyDataSetChanged()

                // Set header text
                val headerView = binding.headerContainer.getChildAt(0)
                headerView.findViewById<TextView>(R.id.textHeader1).text = "No"
                headerView.findViewById<TextView>(R.id.textHeader2).text = "Nama Mitra"
                headerView.findViewById<TextView>(R.id.textHeader3).text = "Tanggal Mulai - Selesai"
                headerView.findViewById<TextView>(R.id.textHeader4).text = "Nominal"
            }
            .addOnFailureListener { exception ->
                // Handle any errors
            }
    }
}
