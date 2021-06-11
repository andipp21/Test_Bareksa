package com.andipputra.testbareksa.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andipputra.testbareksa.data.DetailItemCompany
import com.andipputra.testbareksa.databinding.CompanyItemBinding

class CompanyItemAdapter(private val listDetail: MutableList<DetailItemCompany> = mutableListOf()): RecyclerView.Adapter<CompanyItemAdapter.ViewHolder>() {

    class ViewHolder(private val binding: CompanyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val adapterRV = CompanyDetailAdapter()

        fun bind(detailItem: DetailItemCompany) {
            val title = binding.titleItem
            title.text = detailItem.title

            adapterRV.updateList(detailItem.listText)

            val rv = binding.rvDetailCompany
            rv.adapter = adapterRV
        }
    }

    fun updateList(list: List<DetailItemCompany>){
        listDetail.clear()
        listDetail.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = CompanyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listDetail[position])
    }

    override fun getItemCount(): Int {
        return listDetail.size
    }
}