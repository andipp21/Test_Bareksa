package com.andipputra.testbareksa.ui.main.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andipputra.testbareksa.data.HeaderItemCompany
import com.andipputra.testbareksa.databinding.HeaderCompanyItemBinding

class CompanyHeaderAdapter(private val listHeader: MutableList<HeaderItemCompany> = mutableListOf()) :
    RecyclerView.Adapter<CompanyHeaderAdapter.ViewHolder>() {

    fun updateList(newList: List<HeaderItemCompany>) {
        listHeader.clear()
        listHeader.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: HeaderCompanyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(headerItem: HeaderItemCompany, position: Int) {
            when (position) {
                0 -> {
                    binding.cardHeaderCompany.setBackgroundColor(Color.parseColor("#FFE2EBDD"))
                }
                1 -> {
                    binding.cardHeaderCompany.setBackgroundColor(Color.parseColor("#FFE0DBEB"))
                }
                else -> {
                    binding.cardHeaderCompany.setBackgroundColor(Color.parseColor("#FFE0E8EE"))
                }
            }

            val imageView = binding.companyLogo
            imageView.setImageResource(headerItem.logo)

            val companyName = binding.companyName
            companyName.text = headerItem.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            HeaderCompanyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listHeader[position], position)
    }

    override fun getItemCount(): Int {
        return listHeader.size
    }

}