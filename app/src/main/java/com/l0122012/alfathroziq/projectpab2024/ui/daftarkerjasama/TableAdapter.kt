package com.l0122012.alfathroziq.projectpab2024.ui.daftarkerjasama

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.projectpab2024.R

class TableAdapter(private val data: List<Array<String>>) : RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

    class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textColumn1: TextView = itemView.findViewById(R.id.textColumn1)
        val textColumn2: TextView = itemView.findViewById(R.id.textColumn2)
        val textColumn3: TextView = itemView.findViewById(R.id.textColumn3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return TableViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val rowData = data[position]
        holder.textColumn1.text = rowData[0]
        holder.textColumn2.text = rowData[1]
        holder.textColumn3.text = rowData[2]

        if (position == 0) {
            holder.textColumn1.setTypeface(null, Typeface.BOLD)
            holder.textColumn2.setTypeface(null, Typeface.BOLD)
            holder.textColumn3.setTypeface(null, Typeface.BOLD)
        }
    }

    override fun getItemCount() = data.size
}
