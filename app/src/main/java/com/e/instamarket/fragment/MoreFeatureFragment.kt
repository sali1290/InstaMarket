package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.e.domain.Result
import com.e.instamarket.R
import com.e.instamarket.adapter.ImageSliderAdapter
import com.e.instamarket.databinding.FragmentMoreFeatureBinding
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreFeatureFragment : Fragment() {

    private lateinit var binding: FragmentMoreFeatureBinding
    private lateinit var bannerViewModel: AppInfoViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMoreFeatureBinding.inflate(inflater, container, false)
        bannerViewModel = ViewModelProvider(requireActivity()).get(AppInfoViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.visibility = View.VISIBLE
        observeBanner()

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

        binding.btnRule.setOnClickListener {
            findNavController().navigate(R.id.ruleFragment)
            bottomNav.visibility = View.INVISIBLE
        }

        binding.btnAboutUs.setOnClickListener {
            findNavController().navigate(R.id.aboutUsFragment)
            bottomNav.visibility = View.INVISIBLE
        }

        binding.btnContactUs.setOnClickListener {
            findNavController().navigate(R.id.contactUsFragment)
            bottomNav.visibility = View.INVISIBLE
        }


    }

    private fun observeBanner() {
        bannerViewModel.banner.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {
                    binding.imageSlider3.adapter = ImageSliderAdapter(it.data, requireContext())
                }
                is Result.Loading -> {
                }
                is Result.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }


}