package com.l0122012.alfathroziq.projectpab2024.ui.daftarkerjasama

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.widget.SearchView
import com.l0122012.alfathroziq.projectpab2024.R
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentTableBinding

class TableFragment : Fragment() {

    private lateinit var binding: FragmentTableBinding
    private lateinit var adapter: TableAdapter
    private lateinit var data: List<Array<String>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTableBinding.inflate(inflater, container, false)
        val view = binding.root

        // Ambil argument tableName dari bundle
        val args = TableFragmentArgs.fromBundle(requireArguments())
        val tableName = args.tableName

        val tableId = resources.getIdentifier(tableName, "array", requireActivity().packageName)
        val tableData = resources.getStringArray(tableId)
        data = tableData.map { it.split(";").toTypedArray() }

        adapter = TableAdapter(data.drop(1)) // Drop header row from data
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // Inflate header and add to layout
        val headerView = inflater.inflate(R.layout.item_header_kerjasama, binding.headerContainer, false)
        binding.headerContainer.addView(headerView)

        // Set header text
        val headerRow = data[0]
        headerView.findViewById<TextView>(R.id.textHeader1).text = headerRow[0]
        headerView.findViewById<TextView>(R.id.textHeader2).text = headerRow[1]
        headerView.findViewById<TextView>(R.id.textHeader3).text = headerRow[2]
        headerView.findViewById<TextView>(R.id.textHeader4).text = headerRow[3]

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

        return view
    }
}
