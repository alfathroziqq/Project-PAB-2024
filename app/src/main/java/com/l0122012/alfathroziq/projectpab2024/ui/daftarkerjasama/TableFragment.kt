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
        val rootView = inflater.inflate(R.layout.fragment_table, container, false)

        val tableName = arguments?.getString("TABLE_NAME")

        tableName?.let {
            val tableId = resources.getIdentifier(tableName, "array", requireContext().packageName)
            val tableData = resources.getStringArray(tableId)

            val data = tableData.map { it.split(";").toTypedArray() }

            val recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = TableAdapter(data)
        }

        return rootView
    }
}