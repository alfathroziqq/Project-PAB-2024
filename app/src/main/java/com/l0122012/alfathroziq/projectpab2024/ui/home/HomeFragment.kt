package com.l0122012.alfathroziq.projectpab2024.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.l0122012.alfathroziq.projectpab2024.R
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        val newsImages = resources.obtainTypedArray(R.array.photo_news)
        val newsTitles = resources.getStringArray(R.array.judul_news)
        val newsDetails = resources.getStringArray(R.array.detail_news)

        val newsList = mutableListOf<News>()
        for (i in newsTitles.indices) {
            newsList.add(
                News(
                    newsImages.getResourceId(i, -1),
                    newsTitles[i],
                    newsDetails[i]
                )
            )
        }
        newsImages.recycle()

        binding.newsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = NewsAdapter(newsList) { newsItem ->
                // Handle news item click, navigate to news detail fragment
                // Example: findNavController().navigate(R.id.action_homeFragment_to_newsDetailFragment)
            }
        }
    }
}
