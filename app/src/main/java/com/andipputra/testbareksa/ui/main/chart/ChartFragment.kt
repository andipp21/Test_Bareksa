package com.andipputra.testbareksa.ui.main.chart

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andipputra.testbareksa.R
import com.andipputra.testbareksa.databinding.FragmentChartBinding
import com.andipputra.testbareksa.databinding.FragmentMainBinding
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class ChartFragment : Fragment() {

    private var _binding: FragmentChartBinding? = null
    private val binding get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentChartBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bni = ArrayList<Entry>()
        for (i in 0..12) {
            bni.add(Entry(i.toFloat(), (i * 3).toFloat()))
        }
        val bniLineDataSet = LineDataSet(bni, "BNI")
        bniLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        bniLineDataSet.color = Color.BLUE
        bniLineDataSet.circleRadius = 5f
        bniLineDataSet.setCircleColor(Color.BLUE)

        val cipta = ArrayList<Entry>()
        for (i in 0..12) {
            cipta.add(Entry(i.toFloat(), (i * 2).toFloat()))
        }
        val ciptaLineDataSet = LineDataSet(cipta, "Cipta")
        ciptaLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        ciptaLineDataSet.color = Color.MAGENTA
        ciptaLineDataSet.circleRadius = 5f
        ciptaLineDataSet.setCircleColor(Color.MAGENTA)

        val ascend = ArrayList<Entry>()
        for (i in 0..12) {
            ascend.add(Entry(i.toFloat(), (i * 1).toFloat()))
        }
        val ascendLineDataSet = LineDataSet(ascend, "Ascend")
        ascendLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        ascendLineDataSet.color = Color.GREEN
        ascendLineDataSet.circleRadius = 5f
        ascendLineDataSet.setCircleColor(Color.GREEN)


        //Setup Legend
        val lineChart = binding.chart

        val legend = lineChart.legend
        legend.isEnabled = false
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChartFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}