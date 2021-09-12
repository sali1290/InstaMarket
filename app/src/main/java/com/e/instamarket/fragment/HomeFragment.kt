package com.e.instamarket.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.e.domain.Result
import com.e.instamarket.R
import com.e.instamarket.adapter.ImageSliderAdapter
import com.e.instamarket.databinding.FragmentHomeBinding
import com.e.instamarket.viewmodel.user.UserViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.visibility = View.VISIBLE

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> {
                    findNavController().navigate(R.id.profileFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.home -> {
                    findNavController().navigate(R.id.homeFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.more -> {
                    findNavController().navigate(R.id.moreFeatureFragment)
                    return@setOnItemSelectedListener true
                }

                else -> return@setOnItemSelectedListener true
            }
        }

        binding.imageSlider2.adapter = ImageSliderAdapter()

        viewModel.getUser()
        observe()

        binding.btnCategory.setOnClickListener {
            findNavController().navigate(R.id.categoryFragment)
            bottomNav.visibility = View.INVISIBLE
        }

        binding.btnTransaction.setOnClickListener {
            findNavController().navigate(R.id.transactionFragment)
            bottomNav.visibility = View.INVISIBLE
        }

        binding.btnLuck.setOnClickListener {
            findNavController().navigate(R.id.luckWheelActivity)
        }

    }

    private fun observe() {
        viewModel.user.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {
                    binding.textView5.text = it.data.firstName + " " + it.data.lastName
                    binding.textView10.text = it.data.balance

                }

                is Result.Loading -> {
                    Toast.makeText(requireActivity(), "Loading", Toast.LENGTH_SHORT).show()
                }

                is Result.Error -> {
                    Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()
                }

            }

        })


    }


}