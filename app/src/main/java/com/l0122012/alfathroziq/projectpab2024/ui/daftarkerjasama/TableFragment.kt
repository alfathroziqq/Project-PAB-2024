package com.l0122012.alfathroziq.projectpab2024.ui.daftarkerjasama

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.projectpab2024.R

class TableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_table, container, false)

        // Ambil argument tableName dari bundle
        val args = TableFragmentArgs.fromBundle(requireArguments())
        val tableName = args.tableName

        // Load data tabel berdasarkan tableName
        val tableId = resources.getIdentifier(tableName, "array", requireActivity().packageName)
        val tableData = resources.getStringArray(tableId)
        val data = tableData.map { it.split(";").toTypedArray() }

        // Tampilkan data di RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = TableAdapter(data)

        return view
    }
}

