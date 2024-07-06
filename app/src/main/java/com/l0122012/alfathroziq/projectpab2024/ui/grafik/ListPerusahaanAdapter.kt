package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.projectpab2024.R

class ListPerusahaanAdapter(
    private val list: ArrayList<Perusahaan>,
    private val onItemClick: (Perusahaan) -> Unit
) : RecyclerView.Adapter<ListPerusahaanAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCompany: TextView = itemView.findViewById(R.id.tv_item_company)
        val tvYear: TextView = itemView.findViewById(R.id.tv_item_year)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

        fun bind(perusahaan: Perusahaan) {
            tvCompany.text = perusahaan.company
            tvYear.text = perusahaan.year
            tvDescription.text = perusahaan.description

            itemView.setOnClickListener {
                onItemClick(perusahaan)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_perusahaan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}