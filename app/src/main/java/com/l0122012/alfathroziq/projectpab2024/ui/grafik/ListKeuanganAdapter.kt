package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.projectpab2024.R

class ListKeuanganAdapter(private val listKeuangan: ArrayList<Keuangan>) : RecyclerView.Adapter<ListKeuanganAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvYear: TextView = itemView.findViewById(R.id.tv_item_year)
        val tvMoney: TextView = itemView.findViewById(R.id.tv_item_money)
        val tvCate: TextView = itemView.findViewById(R.id.tv_item_cate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_keuangan, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listKeuangan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (year, money, cate) = listKeuangan[position]
        holder.tvYear.text = year
        holder.tvMoney.text = money.toString()
        holder.tvCate.text = cate
    }
}