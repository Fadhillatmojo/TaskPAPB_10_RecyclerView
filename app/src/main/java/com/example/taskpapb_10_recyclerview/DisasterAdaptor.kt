package com.example.taskpapb_10_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskpapb_10_recyclerview.databinding.ItemDisasterBinding


typealias onClickDisaster = (Disaster) -> Unit

// menerima dua buah parameter, yakni list disasternya, sama onclickdisaster, jadi ketika itemnya itu di click dia dapat menjalankan suatu fungsi
class DisasterAdaptor (private val listDisaster: List<Disaster>, private val onClickDisaster: onClickDisaster) :
    RecyclerView.Adapter<DisasterAdaptor.ItemDisasterViewHolder>(){
    inner class ItemDisasterViewHolder(private val binding: ItemDisasterBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind (data: Disaster){
            with(binding){
                txtDisasterName.text = data.nameDisaster
                txtDisasterType.text = data.typeDisaster
                itemView.setOnClickListener{
                    onClickDisaster(data)
                }
            }
            Glide.with(itemView.context).load(data.imageUrl).into(binding.imageDisaster)
        }
    }

    // untuk menyusun yang akan ditampilkan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder
    {
        val binding = ItemDisasterBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ItemDisasterViewHolder(binding)
    }

    // berisi jumlah item yang akan diisi nantinya
    override fun getItemCount(): Int = listDisaster.size

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }
}