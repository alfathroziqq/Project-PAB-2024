package com.l0122012.alfathroziq.projectpab2024.ui.prosedur

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.projectpab2024.R

class ProcedureAdapter(private val items: List<ProcedureItem>) : RecyclerView.Adapter<ProcedureAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemNumber: TextView = view.findViewById(R.id.item_number)
        val itemTitle: TextView = view.findViewById(R.id.item_title)
        val itemContent: TextView = view.findViewById(R.id.item_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.procedure_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemNumber.text = item.number.toString()
        holder.itemTitle.text = item.title
        holder.itemContent.text = item.content
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
