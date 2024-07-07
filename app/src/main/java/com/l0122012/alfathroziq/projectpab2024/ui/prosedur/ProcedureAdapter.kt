package com.l0122012.alfathroziq.projectpab2024.ui.prosedur

import android.content.Intent
import android.net.Uri
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
        val itemLink: TextView = view.findViewById(R.id.item_link)
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
        if (item.link != null) {
            holder.itemLink.visibility = View.VISIBLE
            holder.itemLink.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
                it.context.startActivity(intent)
            }
        } else {
            holder.itemLink.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
