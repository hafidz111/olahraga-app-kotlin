package com.example.olahraga

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.olahraga.databinding.ItemRowSportBinding

class ListSportAdapter(private val listSport: ArrayList<Sport>) : RecyclerView.Adapter<ListSportAdapter.ListViewHolder> () {
    class ListViewHolder(var binding: ItemRowSportBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowSportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listSport.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, _, photo) = listSport[position]
        holder.binding
            .imgItemPhoto
            .setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description

        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailSport::class.java)
            intentDetail.putExtra(DetailSport.EXTRA_SPORT, listSport[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }


}