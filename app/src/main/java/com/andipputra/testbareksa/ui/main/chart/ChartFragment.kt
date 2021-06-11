package com.andipputra.testbareksa.ui.main.chart

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andipputra.testbareksa.databinding.FragmentChartBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.listener.ChartTouchListener.ChartGesture
import com.github.mikephil.charting.listener.OnChartGestureListener


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
    ): View {

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
        bniLineDataSet.setDrawCircles(false)
        bniLineDataSet.setDrawValues(false)
        bniLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        bniLineDataSet.color = Color.parseColor("#FF668054")
        bniLineDataSet.setCircleColor(Color.parseColor("#FF668054"))

        val cipta = ArrayList<Entry>()
        for (i in 0..12) {
            cipta.add(Entry(i.toFloat(), (i * 2).toFloat()))
        }
        val ciptaLineDataSet = LineDataSet(cipta, "Cipta")
        ciptaLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        ciptaLineDataSet.setDrawCircles(false)
        ciptaLineDataSet.setDrawValues(false)
        ciptaLineDataSet.color = Color.parseColor("#FF725E9C")
        ciptaLineDataSet.setCircleColor(Color.parseColor("#FF725E9C"))

        val ascend = ArrayList<Entry>()
        for (i in 0..12) {
            ascend.add(Entry(i.toFloat(), (i * 1).toFloat()))
        }
        val ascendLineDataSet = LineDataSet(ascend, "Ascend")
        ascendLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        ascendLineDataSet.setDrawValues(false)
        ascendLineDataSet.setDrawCircles(false)
        ascendLineDataSet.color = Color.parseColor("#FF6D98B6")
        ascendLineDataSet.setCircleColor(Color.parseColor("#FF6D98B6"))


        //Setup Legend
        val lineChart = binding.chart

        val legend = lineChart.legend
        legend.isEnabled = false

        lineChart.axisLeft.setDrawGridLines(false)
        lineChart.axisLeft.setDrawLabels(false)
        lineChart.xAxis.setDrawLabels(false)
        lineChart.xAxis.setDrawGridLines(false)
        lineChart.description.isEnabled = false
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lineChart.data = LineData(bniLineDataSet, ciptaLineDataSet, ascendLineDataSet)
        lineChart.animateXY(100, 500)

        lineChart.onChartGestureListener = object : OnChartGestureListener {
            override fun onChartTranslate(me: MotionEvent, dX: Float, dY: Float) {
            }

            override fun onChartSingleTapped(me: MotionEvent) {
                if (bniLineDataSet.isDrawCirclesEnabled) {
                    bniLineDataSet.setDrawCircles(false)
                } else {
                    bniLineDataSet.setDrawCircles(true)
                }

                if (ciptaLineDataSet.isDrawCirclesEnabled) {
                    ciptaLineDataSet.setDrawCircles(false)
                } else {
                    ciptaLineDataSet.setDrawCircles(true)
                }

                if (ascendLineDataSet.isDrawCirclesEnabled) {
                    ascendLineDataSet.setDrawCircles(false)
                } else {
                    ascendLineDataSet.setDrawCircles(true)
                }
            }

            override fun onChartScale(me: MotionEvent, scaleX: Float, scaleY: Float) {
            }

            override fun onChartGestureStart(me: MotionEvent, lastPerformedGesture: ChartGesture) {}
            override fun onChartGestureEnd(me: MotionEvent, lastPerformedGesture: ChartGesture) {}
            override fun onChartLongPressed(me: MotionEvent) {
            }

            override fun onChartFling(
                me1: MotionEvent, me2: MotionEvent,
                velocityX: Float, velocityY: Float
            ) {
            }

            override fun onChartDoubleTapped(me: MotionEvent) {
            }
        }
    }
}