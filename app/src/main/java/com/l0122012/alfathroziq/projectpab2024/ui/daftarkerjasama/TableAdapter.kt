package com.l0122012.alfathroziq.projectpab2024.ui.daftarkerjasama

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.projectpab2024.R

class TableAdapter(private var data: List<Array<String>>) : RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

    private var filteredData = data.toMutableList()

    class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textColumn1: TextView = itemView.findViewById(R.id.textColumn1)
        val textColumn2: TextView = itemView.findViewById(R.id.textColumn2)
        val textColumn3: TextView = itemView.findViewById(R.id.textColumn3)
        val textColumn4: TextView = itemView.findViewById(R.id.textColumn4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return TableViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val rowData = filteredData[position]
        holder.textColumn1.text = rowData[0]
        holder.textColumn2.text = rowData[1]
        holder.textColumn3.text = rowData[2]
        holder.textColumn4.text = rowData[3]
    }

    override fun getItemCount() = filteredData.size

    fun filter(query: String) {
        filteredData = if (query.isEmpty()) {
            data.toMutableList()
        } else {
            val filteredList = data.filter { row ->
                row.any { column -> column.contains(query, ignoreCase = true) }
            }
            filteredList.toMutableList()
        }
        notifyDataSetChanged()
    }

    fun setData(newData: List<Array<String>>) {
        data = newData
        filteredData = newData.toMutableList()
        notifyDataSetChanged()
    }
}
