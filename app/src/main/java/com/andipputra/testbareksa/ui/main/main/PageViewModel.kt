package com.andipputra.testbareksa.ui.main.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.andipputra.testbareksa.R
import com.andipputra.testbareksa.data.DetailItemCompany
import com.andipputra.testbareksa.data.HeaderItemCompany
import com.andipputra.testbareksa.data.ManagerInvestasi

class PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }


    private val _listCompanyHeader = MutableLiveData<List<HeaderItemCompany>>()
    val listCompanyHeader: LiveData<List<HeaderItemCompany>> = _listCompanyHeader

    private val _listCompanyDetail = MutableLiveData<List<DetailItemCompany>>()
    val listCompanyDetail: LiveData<List<DetailItemCompany>> = _listCompanyDetail

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun setDataComparasion() {
        val listManajerInvestasi = mutableListOf<ManagerInvestasi>()

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

        setCompanyHeader(listManajerInvestasi)

        setCompanyDetail(listManajerInvestasi)

    }

    private fun setCompanyHeader(list: List<ManagerInvestasi>) {
        val listHeader = mutableListOf<HeaderItemCompany>()

        list.forEach {
            listHeader.add(HeaderItemCompany(it.logo, it.name))
        }

        _listCompanyHeader.value = listHeader
    }

    private fun setCompanyDetail(list: List<ManagerInvestasi>) {
        val listDetail = mutableListOf<DetailItemCompany>()

        val listJenisReksaDana = mutableListOf<String>()
        val listImbalHasil = mutableListOf<String>()
        val listDanaKelolaan = mutableListOf<String>()
        val listMinPembelian = mutableListOf<String>()
        val listJangkaWaktu = mutableListOf<String>()
        val listTingkatRisiko = mutableListOf<String>()
        val listPeluncuran = mutableListOf<String>()

        list.forEach {
            listJenisReksaDana.add(it.jenisReksaDana)
            listImbalHasil.add(it.imbalHasil)
            listDanaKelolaan.add(it.danaKelolaan)
            listMinPembelian.add(it.minPembelian)
            listJangkaWaktu.add(it.jangkaWaktu)
            listTingkatRisiko.add(it.tingkatRisiko)
            listPeluncuran.add(it.peluncuran)
        }

        listDetail.add(DetailItemCompany("Jenis reksa dana", listJenisReksaDana))
        listDetail.add(DetailItemCompany("Imbal hasil", listImbalHasil))
        listDetail.add(DetailItemCompany("Dana kelolaan", listDanaKelolaan))
        listDetail.add(DetailItemCompany("Min. pembelian", listMinPembelian))
        listDetail.add(DetailItemCompany("Jangka waktu", listJangkaWaktu))
        listDetail.add(DetailItemCompany("Tingkat risiko", listTingkatRisiko))
        listDetail.add(DetailItemCompany("Peluncuran", listPeluncuran))

        _listCompanyDetail.value = listDetail
    }
}