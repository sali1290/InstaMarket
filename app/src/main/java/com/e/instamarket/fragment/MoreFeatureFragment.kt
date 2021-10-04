package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.e.instamarket.R
import com.e.instamarket.adapter.ImageSliderAdapter
import com.e.instamarket.databinding.FragmentMoreFeatureBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreFeatureFragment : Fragment() {

    private lateinit var binding: FragmentMoreFeatureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMoreFeatureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.visibility = View.VISIBLE

        binding.imageSlider3.adapter = ImageSliderAdapter()

        binding.news.setOnClickListener {
            findNavController().navigate(R.id.newsFragment)
            bottomNav.visibility = View.INVISIBLE
        }

        binding.btnApi.setOnClickListener {
            findNavController().navigate(R.id.apiFragment)
            bottomNav.visibility = View.INVISIBLE
        }

        binding.btnAgents.setOnClickListener {
            findNavController().navigate(R.id.agentFragment)
            bottomNav.visibility = View.INVISIBLE
        }

        binding.buySite.setOnClickListener {
            findNavController().navigate(R.id.sitesFragment)
            bottomNav.visibility = View.INVISIBLE
        }

        binding.btnFaq.setOnClickListener {
            findNavController().navigate(R.id.faqFragment)
            bottomNav.visibility = View.INVISIBLE
        }

    }
}