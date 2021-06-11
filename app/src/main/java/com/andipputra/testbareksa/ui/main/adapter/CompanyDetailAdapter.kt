package com.andipputra.testbareksa.ui.main.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andipputra.testbareksa.databinding.DetailCompanyItemBinding

class CompanyDetailAdapter(private val listDetail: MutableList<String> = mutableListOf()): RecyclerView.Adapter<CompanyDetailAdapter.ViewHolder>() {
    class ViewHolder(private val binding: DetailCompanyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(detailItem: String, position: Int) {
            when (position) {
                0 -> {
                    binding.cardDetail.setBackgroundColor(Color.parseColor("#FFE2EBDD"))
                }
                1 -> {
                    binding.cardDetail.setBackgroundColor(Color.parseColor("#FFE0DBEB"))
                }
                else -> {
                    binding.cardDetail.setBackgroundColor(Color.parseColor("#FFE0E8EE"))
                }
            }
            val title = binding.detailText
            title.text = detailItem
        }
    }

    fun updateList(list: List<String>){
        listDetail.clear()
        listDetail.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = DetailCompanyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listDetail[position], position)
    }

    override fun getItemCount(): Int {
        return listDetail.size
    }
}