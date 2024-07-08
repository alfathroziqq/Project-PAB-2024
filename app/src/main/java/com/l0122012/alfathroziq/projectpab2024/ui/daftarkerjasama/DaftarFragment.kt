package com.l0122012.alfathroziq.projectpab2024.ui.daftarkerjasama

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.l0122012.alfathroziq.projectpab2024.R

class DaftarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_daftar, container, false)

        view.findViewById<View>(R.id.button1).setOnClickListener { openTableFragment("table_data_1") }
        view.findViewById<View>(R.id.button2).setOnClickListener { openTableFragment("table_data_2") }
        view.findViewById<View>(R.id.button3).setOnClickListener { openTableFragment("table_data_3") }
        view.findViewById<View>(R.id.button4).setOnClickListener { openTableFragment("table_data_4") }
        view.findViewById<View>(R.id.button5).setOnClickListener { openTableFragment("table_data_5") }
        view.findViewById<View>(R.id.button6).setOnClickListener { openTableFragment("table_data_6") }
        view.findViewById<View>(R.id.button7).setOnClickListener { openTableFragment("table_data_7") }

        return view
    }

    private fun openTableFragment(tableName: String) {
        val action = DaftarFragmentDirections.actionNavDaftarkerjasamaToNavTabelkerjasama(tableName)
        findNavController().navigate(action)
    }
}
