package com.andipputra.testbareksa.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andipputra.testbareksa.databinding.ButtonCompanyItemBinding

class CompanyButtonAdapter(private var dataLength: Int) :
    RecyclerView.Adapter<CompanyButtonAdapter.ViewHolder>() {
    inner class ViewHolder(binding: ButtonCompanyItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            ButtonCompanyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return dataLength
    }
}