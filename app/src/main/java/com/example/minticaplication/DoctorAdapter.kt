package com.example.minticaplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.minticaplication.databinding.ItemDoctorBinding

class DoctorAdapter(var list: List<DoctorModel>): RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {

    class ViewHolder(val view: ItemDoctorBinding): RecyclerView.ViewHolder(view.root)
    var listener: OnDoctorClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemDoctorBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: DoctorAdapter.ViewHolder, position: Int) {
        val doctor = list[position]
        holder.view.itemDoctorName.text = doctor.name
        holder.view.itemDoctorEspecialidad.text = doctor.especialidad
        holder.view.itemDoctorIcon.setImageResource(doctor.image.toInt())

        holder.view.root.setOnClickListener {
            listener?.onClick(doctor)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun UpdateSet(newList: List<DoctorModel>) {
        this.list = newList
        notifyDataSetChanged()
    }
}