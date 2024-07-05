package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.projectpab2024.R

class ListPerusahaanAdapter(private val listPerusahaan: ArrayList<Perusahaan>) : RecyclerView.Adapter<ListPerusahaanAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvYear: TextView = itemView.findViewById(R.id.tv_item_year)
        val tvCompany: TextView = itemView.findViewById(R.id.tv_item_company)
        val tvMoney: TextView = itemView.findViewById(R.id.tv_item_money)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_perusahaan, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPerusahaan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (year, company, money) = listPerusahaan[position]
        holder.tvYear.text = year
        holder.tvCompany.text = company
        holder.tvMoney.text = money.toString()
    }
}