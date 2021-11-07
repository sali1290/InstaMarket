package com.e.instamarket.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.e.domain.Result
import com.e.instamarket.R
import com.e.instamarket.adapter.ImageSliderAdapter
import com.e.instamarket.databinding.FragmentHomeBinding
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel
import com.e.instamarket.viewmodel.enterApp.EnterAppViewModel
import com.e.instamarket.viewmodel.user.UserViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: EnterAppViewModel
    private lateinit var userViewModel: UserViewModel
    private lateinit var bannerViewModel: AppInfoViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(EnterAppViewModel::class.java)
        userViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
        bannerViewModel = ViewModelProvider(requireActivity()).get(AppInfoViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val btnHome = requireActivity().findViewById<CardView>(R.id.btn_home)
        bottomNav.visibility = View.VISIBLE
        btnHome.visibility = View.VISIBLE

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> {

                    requireActivity().onBackPressedDispatcher.addCallback(
                        requireActivity(),
                        object : OnBackPressedCallback(true) {
                            override fun handleOnBackPressed() {
                                if (bottomNav.selectedItemId == R.id.profile) {
                                    bottomNav.selectedItemId = R.id.home
                                } else {
                                    isEnabled = false
                                    requireActivity().onBackPressed()
                                }
                            }
                        })

                    findNavController().navigate(R.id.profileFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.home -> {

                    requireActivity().onBackPressedDispatcher.addCallback(
                        requireActivity(),
                        object : OnBackPressedCallback(true) {
                            override fun handleOnBackPressed() {
                                if (bottomNav.selectedItemId == R.id.home) {
                                    requireActivity().finish()
                                } else {
                                    isEnabled = false
                                    requireActivity().onBackPressed()
                                }
                            }
                        })

                    findNavController().navigate(R.id.homeFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.more -> {

                    requireActivity().onBackPressedDispatcher.addCallback(
                        requireActivity(),
                        object : OnBackPressedCallback(true) {
                            override fun handleOnBackPressed() {
                                if (bottomNav.selectedItemId == R.id.more) {
                                    bottomNav.selectedItemId = R.id.home
                                } else {
                                    isEnabled = false
                                    requireActivity().onBackPressed()
                                }
                            }
                        })

                    findNavController().navigate(R.id.moreFeatureFragment)
                    return@setOnItemSelectedListener true
                }

                else -> return@setOnItemSelectedListener true
            }
        }


        viewModel.getUser()
        bannerViewModel.getBanners()
        observeBanner()
        observeUser()

        binding.btnCategory.setOnClickListener {
            bottomNav.selectedItemId = R.id.profile
            findNavController().navigate(R.id.categoryFragment)
            bottomNav.visibility = View.INVISIBLE
            btnHome.visibility = View.INVISIBLE
        }

        binding.btnTransaction.setOnClickListener {
            bottomNav.selectedItemId = R.id.profile
            findNavController().navigate(R.id.transactionFragment)
            bottomNav.visibility = View.INVISIBLE
            btnHome.visibility = View.INVISIBLE
        }

        binding.btnLuck.setOnClickListener {
            findNavController().navigate(R.id.luckWheelActivity)
        }

        binding.btnOrderReport.setOnClickListener {
            bottomNav.selectedItemId = R.id.profile
            findNavController().navigate(R.id.ordersFragment)
            bottomNav.visibility = View.INVISIBLE
            btnHome.visibility = View.INVISIBLE
        }

        binding.btnRaiseStock.setOnClickListener {
            bottomNav.selectedItemId = R.id.profile
            findNavController().navigate(R.id.raiseStockFragment)
            bottomNav.visibility = View.INVISIBLE
            btnHome.visibility = View.INVISIBLE
        }

        binding.btnPay.setOnClickListener {
            bottomNav.selectedItemId = R.id.profile
            findNavController().navigate(R.id.transactionFragment)
            bottomNav.visibility = View.INVISIBLE
            btnHome.visibility = View.INVISIBLE
        }

        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

    }

    private fun observeUser() {
        val progressBar = requireActivity().findViewById<ProgressBar>(R.id.progressBar)
        viewModel.user.observe(viewLifecycleOwner, { it ->

            when (it) {

                is Result.Success -> {
                    progressBar.visibility = View.INVISIBLE
                    val role = it.data.role
                    if (role == "admin") {
                        binding.textView5.text = "مدیر"
                    } else {
                        binding.textView5.text = "کاربر"
                    }
                    binding.textView10.text = it.data.firstName + " " + it.data.lastName
                    binding.textView31.text = it.data.balance

                }

                is Result.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }

                is Result.Error -> {
//                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_SHORT).show()
                    userViewModel.getUser()
                    userViewModel.user.observe(viewLifecycleOwner, {
                        when (it) {
                            is Result.Success -> {
                                progressBar.visibility = View.INVISIBLE
                                val role = it.data.role
                                if (role == "admin") {
                                    binding.textView5.text = "مدیر"
                                } else {
                                    binding.textView5.text = "کاربر"
                                }
                                binding.textView10.text = it.data.firstName + " " + it.data.lastName
                                binding.textView31.text = it.data.balance
                            }
                            is Result.Loading -> {
                            }
                            is Result.Error -> {
                                Toast.makeText(
                                    requireActivity(),
                                    "لطفا اتصال اینترنت خود را بررسی کنید",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    })

                }
            }
        })
    }


    private fun observeBanner() {
        bannerViewModel.banner.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {
                    binding.imageSlider2.adapter = ImageSliderAdapter(it.data, requireContext())
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