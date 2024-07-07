package com.l0122012.alfathroziq.projectpab2024.ui.prosedur

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.l0122012.alfathroziq.projectpab2024.R
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentProsedurBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

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

        val youTubePlayerView: YouTubePlayerView = binding.root.findViewById(R.id.youtube_player_view)
        lifecycle.addObserver(youTubePlayerView)

        return binding.root
    }

    @SuppressLint("InflateParams")
    private fun showBottomSheet() {
        val dialog = BottomSheetDialog(requireContext(), R.style.CustomBottomSheetDialogTheme)
        val sheetView = layoutInflater.inflate(R.layout.bottomsheet, null)
        val recyclerView: RecyclerView = sheetView.findViewById(R.id.recyclerView)

        // Mengambil data dari Firestore
        val db = Firebase.firestore
        val collectionPath = "kerjasama/prosedur/prosedur-kerjasama"

        db.collection(collectionPath)
            .orderBy("number")
            .get()
            .addOnSuccessListener { result ->
                val items = result.map { document ->
                    ProcedureItem(
                        number = document.getLong("number")?.toInt() ?: 0,
                        title = document.getString("title") ?: "",
                        content = document.getString("content") ?: "",
                        link = document.getString("link")
                    )
                }

                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                recyclerView.adapter = ProcedureAdapter(items)

                dialog.setContentView(sheetView)

                val bottomSheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
                bottomSheet?.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_bottom_sheet)

                val behavior = BottomSheetBehavior.from(sheetView.parent as View)
                behavior.peekHeight = (resources.displayMetrics.heightPixels * 0.7).toInt()
                behavior.maxHeight = (resources.displayMetrics.heightPixels * 0.7).toInt()
                behavior.expandedOffset = (resources.displayMetrics.heightPixels * 0.3).toInt()
                dialog.show()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
