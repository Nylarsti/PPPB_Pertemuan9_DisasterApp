package com.example.pertemuan9_disasterapp

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan9_disasterapp.databinding.ItemDisasterBinding
import android.view.ViewGroup

typealias OnClickDisaster = (Disaster) -> Unit
class DisasterAdapter(private val listDisaster: List<Disaster>, private val
onClickDisaster: OnClickDisaster) :
    RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>() {
    inner class ItemDisasterViewHolder(private val binding: ItemDisasterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Disaster) {
            with(binding) {
                txtDisasterName.text = data.nameDisaster
                txtDisasterType.text = data.disasterType

                //handle on click
                itemView.setOnClickListener {
                    onClickDisaster(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemDisasterViewHolder {
        val binding =
            ItemDisasterBinding.inflate(LayoutInflater.from(parent.context), parent,
                false)
        return ItemDisasterViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return listDisaster.size
    }
    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position:
    Int) {
        holder.bind(listDisaster[position])
    }

}