package com.l0122012.alfathroziq.projectpab2024.ui.prosedur

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.l0122012.alfathroziq.projectpab2024.R
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentProsedurBinding

class ProsedurFragment : Fragment() {

    private var _binding: FragmentProsedurBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProsedurBinding.inflate(inflater, container, false)

        val unduh: TextView = binding.unduh
        unduh.setOnClickListener {
            val url = "https://drive.google.com/file/d/19Mp_tY5-LfugtGm9JfQPAHkAcl5ScEZQ/view"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            startActivity(intent)
        }

        val imageProsedur: View = binding.root.findViewById(R.id.image_prosedur)
        imageProsedur.setOnClickListener {
            showBottomSheet()
        }

        return binding.root
    }

    @SuppressLint("InflateParams")
    private fun showBottomSheet() {
        val dialog = BottomSheetDialog(requireContext())
        val sheetView = layoutInflater.inflate(R.layout.bottomsheet, null)
        val recyclerView: RecyclerView = sheetView.findViewById(R.id.recyclerView)

        val titles = resources.getStringArray(R.array.procedure_titles)
        val descriptions = resources.getStringArray(R.array.procedure_descriptions)

        val items = titles.indices.map { index ->
            ProcedureItem(index + 1, titles[index], descriptions[index])
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ProcedureAdapter(items)

        dialog.setContentView(sheetView)
        val behavior = BottomSheetBehavior.from(sheetView.parent as View)
        behavior.peekHeight = (resources.displayMetrics.heightPixels * 0.7).toInt()
        behavior.maxHeight = (resources.displayMetrics.heightPixels * 0.7).toInt()
        behavior.expandedOffset = (resources.displayMetrics.heightPixels * 0.3).toInt()
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
