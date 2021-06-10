package com.andipputra.testbareksa.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.andipputra.testbareksa.databinding.FragmentMainBinding
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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

//        val textView: TextView = binding.sectionLabel
//        pageViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bni = ArrayList<Entry>()
        for(i in 0..12){
            bni.add(Entry(i.toFloat(), (i*3).toFloat()))
        }
        val bniLineDataSet = LineDataSet(bni, "BNI")
        bniLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        bniLineDataSet.color = Color.BLUE
        bniLineDataSet.circleRadius = 5f
        bniLineDataSet.setCircleColor(Color.BLUE)

        val cipta = ArrayList<Entry>()
        for(i in 0..12){
            cipta.add(Entry(i.toFloat(), (i*2).toFloat()))
        }
        val ciptaLineDataSet = LineDataSet(cipta, "Cipta")
        ciptaLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        ciptaLineDataSet.color = Color.MAGENTA
        ciptaLineDataSet.circleRadius = 5f
        ciptaLineDataSet.setCircleColor(Color.MAGENTA)

        val ascend = ArrayList<Entry>()
        for(i in 0..12){
            ascend.add(Entry(i.toFloat(), (i*1).toFloat()))
        }
        val ascendLineDataSet = LineDataSet(ascend, "Ascend")
        ascendLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        ascendLineDataSet.color = Color.GREEN
        ascendLineDataSet.circleRadius = 5f
        ascendLineDataSet.setCircleColor(Color.GREEN)


        //Setup Legend
        val lineChart = binding.chart

        val legend = lineChart.legend
        legend.isEnabled = true
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        legend.orientation = Legend.LegendOrientation.HORIZONTAL
        legend.setDrawInside(false)

        lineChart.description.isEnabled = false
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lineChart.data = LineData(bniLineDataSet, ciptaLineDataSet, ascendLineDataSet)
        lineChart.animateXY(100, 500)
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}