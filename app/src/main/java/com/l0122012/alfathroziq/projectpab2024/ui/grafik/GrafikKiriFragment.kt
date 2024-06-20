package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.PercentFormatter
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentGrafikKiriBinding

class GrafikKiriFragment : Fragment() {
    private var _binding: FragmentGrafikKiriBinding? = null
    private val binding get() = _binding!!

    private lateinit var barChart: BarChart
    private lateinit var pieChart: PieChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGrafikKiriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        barChart = binding.barChart
        pieChart = binding.pieChart

        setupBarChart()
        setupPieChart()
    }

    private fun setupBarChart() {
        val entries: ArrayList<BarEntry> = ArrayList()
        entries.add(BarEntry(0f, 1000000f))
        entries.add(BarEntry(1f, 900000f))
        entries.add(BarEntry(2f, 750000f))
        entries.add(BarEntry(3f, 1400000f))
        entries.add(BarEntry(4f, 1600000f))
        entries.add(BarEntry(5f, 500000f))
        entries.add(BarEntry(6f, 400000f))
        entries.add(BarEntry(7f, 1200000f))
        entries.add(BarEntry(8f, 1500000f))
        entries.add(BarEntry(9f, 1200000f))

        val barDataSet = BarDataSet(entries, "")
        barDataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()
        barDataSet.valueTextColor = Color.BLACK

        val barData = BarData(barDataSet)

        barChart.setFitBars(true)
        barChart.data = barData

        val xAxis: XAxis = barChart.xAxis
        val years = arrayOf("2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024")
        xAxis.valueFormatter = IndexAxisValueFormatter(years)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(true)
        xAxis.granularity = 1f
        xAxis.isGranularityEnabled = true
        xAxis.labelCount = years.size

        // Disable the right Y-axis
        barChart.axisRight.isEnabled = false

        // Animasi untuk BarChart
        val animationDuration = 1000L
        barChart.animateY(animationDuration.toInt())
    }

    private fun setupPieChart() {
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(1000000f, "2015"))
        entries.add(PieEntry(900000f, "2016"))
        entries.add(PieEntry(750000f, "2017"))
        entries.add(PieEntry(1400000f, "2018"))
        entries.add(PieEntry(1600000f, "2019"))
        entries.add(PieEntry(500000f, "2020"))
        entries.add(PieEntry(400000f, "2021"))
        entries.add(PieEntry(1200000f, "2022"))
        entries.add(PieEntry(1500000f, "2023"))
        entries.add(PieEntry(1200000f, "2024"))

        val pieDataSet = PieDataSet(entries, "")
        pieDataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()
        pieDataSet.valueTextColor = Color.BLACK

        val pieData = PieData(pieDataSet)

        pieChart.data = pieData

        // Animasi untuk PieChart
        pieChart.animateY(1000)

        // Konfigurasi tambahan untuk PieChart
        pieChart.setUsePercentValues(false)
        pieChart.setDrawEntryLabels(false)
        pieChart.description.isEnabled = false
        pieChart.legend.isEnabled = true
        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 50f
        pieChart.transparentCircleRadius = 55f

        // Menambahkan keterangan pada PieChart
        pieDataSet.valueFormatter = PercentFormatter(pieChart)
        pieDataSet.valueTextSize = 12f
        pieDataSet.valueTextColor = Color.WHITE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
