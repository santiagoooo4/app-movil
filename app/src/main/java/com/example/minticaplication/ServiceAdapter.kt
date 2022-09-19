package com.example.minticaplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.minticaplication.databinding.ItemServiceBinding

class ServiceAdapter(var list: List<ServiceModel>): RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {

    var listener: OnServiceClickListener? = null

    inner  class ViewHolder(val view: ItemServiceBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        return ViewHolder(ItemServiceBinding.inflate(inflater, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.view.itemServiceTitle.text = item.title
        holder.view.itemServiceDescription.text = item.descripcion
        holder.view.itemServiceIcon.setImageResource(item.icon.toInt())

        holder.view.root.setOnClickListener{
            listener?.onClick(item)
        }
    }
    override fun getItemCount(): Int {
        return list.count()
    }
}