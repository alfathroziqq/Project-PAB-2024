package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
import com.l0122012.alfathroziq.projectpab2024.R
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentGrafikKananBinding

class GrafikKananFragment : Fragment() {
    private var _binding: FragmentGrafikKananBinding? = null
    private val binding get() = _binding!!

    private lateinit var barChart: BarChart
    private lateinit var pieChart: PieChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGrafikKananBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        barChart = binding.barChartjumlah
        pieChart = binding.pieChartjumlah

        setupBarChart()
        setupPieChart()

        binding.buttonperusahaankanan.setOnClickListener {
            findNavController().navigate(R.id.action_grafikKananFragment_to_detailPerusahaanKananFragment)
        }
    }

    private fun setupBarChart() {
        val entries: ArrayList<BarEntry> = ArrayList()
        entries.add(BarEntry(0f, 3f))
        entries.add(BarEntry(1f, 2f))
        entries.add(BarEntry(2f, 2f))
        entries.add(BarEntry(3f, 3f))
        entries.add(BarEntry(4f, 3f))
        entries.add(BarEntry(5f, 1f))
        entries.add(BarEntry(6f, 1f))
        entries.add(BarEntry(7f, 2f))
        entries.add(BarEntry(8f, 2f))
        entries.add(BarEntry(9f, 2f))

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
        entries.add(PieEntry(3f, "2015"))
        entries.add(PieEntry(2f, "2016"))
        entries.add(PieEntry(2f, "2017"))
        entries.add(PieEntry(3f, "2018"))
        entries.add(PieEntry(3f, "2019"))
        entries.add(PieEntry(1f, "2020"))
        entries.add(PieEntry(1f, "2021"))
        entries.add(PieEntry(2f, "2022"))
        entries.add(PieEntry(2f, "2023"))
        entries.add(PieEntry(2f, "2024"))

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
