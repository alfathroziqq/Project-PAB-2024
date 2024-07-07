package com.l0122012.alfathroziq.projectpab2024.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.l0122012.alfathroziq.projectpab2024.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!
    private val args: NewsDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsItem = args.newsItem

        binding.newsDetailTitle.text = newsItem?.title
        newsItem?.imageResId?.let { binding.newsDetailImage.setImageResource(it) }
        binding.newsDetailText.text = newsItem?.detail
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}