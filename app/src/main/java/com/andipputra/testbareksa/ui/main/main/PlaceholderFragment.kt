package com.andipputra.testbareksa.ui.main.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.andipputra.testbareksa.R
import com.andipputra.testbareksa.databinding.FragmentMainBinding
import com.andipputra.testbareksa.ui.main.adapter.CompanyButtonAdapter
import com.andipputra.testbareksa.ui.main.adapter.CompanyHeaderAdapter
import com.andipputra.testbareksa.ui.main.adapter.CompanyItemAdapter
import com.andipputra.testbareksa.ui.main.adapter.TimePagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class PlaceholderFragment : Fragment() {

    private val TIME_TAB_TITLES = arrayOf(
        R.string.one_week,
        R.string.one_month,
        R.string.one_year,
        R.string.third_year,
        R.string.five_year,
        R.string.ten_year,
        R.string.all,
    )

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    private var _companyHeaderAdapter: CompanyHeaderAdapter? = null
    private val companyHeaderAdapter get() = _companyHeaderAdapter!!

    private var _companyItemAdapater: CompanyItemAdapter? = null
    private val companyItemAdapter get() = _companyItemAdapater!!

    private var _companyButtonAdapter: CompanyButtonAdapter? = null
    private val companyButtonAdapter get() = _companyButtonAdapter!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)

        val timePagerAdapater = TimePagerAdapter(this, TIME_TAB_TITLES.size)

        val timeTab = binding.timeTabs
        val viewPager = binding.chartViewPager
        viewPager.adapter = timePagerAdapater

        TabLayoutMediator(timeTab, viewPager) { tab, position ->
            tab.text = resources.getString(TIME_TAB_TITLES[position])
        }.attach()

        _companyHeaderAdapter = CompanyHeaderAdapter()
        _companyItemAdapater = CompanyItemAdapter()
        _companyButtonAdapter = CompanyButtonAdapter(3)


        pageViewModel.setDataComparasion()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        pageViewModel.listCompanyHeader.observe(viewLifecycleOwner, {
            companyHeaderAdapter.updateList(it)

        })

        pageViewModel.listCompanyDetail.observe(viewLifecycleOwner, {
            companyItemAdapter.updateList(it)
        })

        binding.headerCompanyRv.adapter = companyHeaderAdapter
        binding.detailCompanyRv.adapter = companyItemAdapter
        binding.buttonCompanyRv.adapter = companyButtonAdapter
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _companyHeaderAdapter = null
        _companyItemAdapater = null
        _companyButtonAdapter = null
    }
}