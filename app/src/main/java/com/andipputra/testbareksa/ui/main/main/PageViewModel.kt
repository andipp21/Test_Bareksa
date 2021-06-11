package com.andipputra.testbareksa.ui.main.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andipputra.testbareksa.R
import com.andipputra.testbareksa.data.DetailItemCompany
import com.andipputra.testbareksa.data.HeaderItemCompany
import com.andipputra.testbareksa.data.ManagerInvestasi

class   PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }

    private val _listManagerInvestasi = MutableLiveData<List<ManagerInvestasi>>()
    val listManagerInvestasi: LiveData<List<ManagerInvestasi>> = _listManagerInvestasi

    private val _listCompanyHeader = MutableLiveData<LiveData<HeaderItemCompany>>()

    private val _listCompanyDetail = MutableLiveData<LiveData<DetailItemCompany>>()

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun setDataComparasion(){
        val listManajerInvestasi =  mutableListOf<ManagerInvestasi>()

        val managerInvestasiBni = ManagerInvestasi(
            R.drawable.ic_bni_logo,
            "BNI-AM Inspiring Equity Fund",
            "Saham",
            "5,5% / 5 thn",
            "3,64 Miliar",
            "1 Juta",
            "5 Tahun",
            "Tinggi",
            "16 Apr 2014"
        )

        val managerInvestasiCiptaDana = ManagerInvestasi(
            R.drawable.ic_bni_logo,
            "BNI-AM Inspiring Equity Fund",
            "Saham",
            "5,5% / 5 thn",
            "3,64 Miliar",
            "1 Juta",
            "5 Tahun",
            "Tinggi",
            "16 Apr 2014"
        )

        val managerInvestasiAscend = ManagerInvestasi(
            R.drawable.ic_bni_logo,
            "BNI-AM Inspiring Equity Fund",
            "Saham",
            "5,5% / 5 thn",
            "3,64 Miliar",
            "1 Juta",
            "5 Tahun",
            "Tinggi",
            "16 Apr 2014"
        )

        listManajerInvestasi.add(managerInvestasiAscend)
        listManajerInvestasi.add(managerInvestasiBni)
        listManajerInvestasi.add(managerInvestasiCiptaDana)

        _listManagerInvestasi.value = listManajerInvestasi
    }
}