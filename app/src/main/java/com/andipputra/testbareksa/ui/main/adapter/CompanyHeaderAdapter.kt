package com.andipputra.testbareksa.ui.main.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andipputra.testbareksa.data.ManagerInvestasi
import com.andipputra.testbareksa.databinding.HeaderCompanyItemBinding

class CompanyHeaderAdapter(val listHeader: MutableList<ManagerInvestasi> = mutableListOf()) :
    RecyclerView.Adapter<CompanyHeaderAdapter.ViewHolder>() {

    fun updateList(newList: List<ManagerInvestasi>) {
        listHeader.clear()
        listHeader.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: HeaderCompanyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(managerInvestasi: ManagerInvestasi, position: Int) {
            if (position/2 == 1){
                binding.cardHeaderCompany.setBackgroundColor(Color.parseColor("#FFE0DBEB"))
            }

            val imageView = binding.companyLogo
            imageView.setImageResource(managerInvestasi.logo)

            val companyName = binding.companyName
            companyName.text = managerInvestasi.name
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