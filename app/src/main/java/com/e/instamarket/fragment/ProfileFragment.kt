package com.e.instamarket.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.e.data.utile.SessionManager
import com.e.domain.Result
import com.e.instamarket.R
import com.e.instamarket.adapter.ProfileBankAdapter
import com.e.instamarket.adapter.ProfileInfoAdapter
import com.e.instamarket.databinding.FragmentProfileBinding
import com.e.instamarket.viewmodel.enterApp.EnterAppViewModel
import com.e.instamarket.viewmodel.user.UserViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewModel: EnterAppViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(EnterAppViewModel::class.java)

        observe()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val btnHome = requireActivity().findViewById<CardView>(R.id.btn_home)
        bottomNav.visibility = View.VISIBLE
        btnHome.visibility = View.VISIBLE

        viewModel.getUser()

        val sessionManager = SessionManager(requireContext())

        binding.btnLogout.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
            dialog.setPositiveButton("بله") { _, _ ->
                sessionManager.saveAuthToken(null)

                try {
                    // clearing app data
                    val packageName: String = requireContext().applicationContext.packageName
                    val runtime = Runtime.getRuntime()
                    runtime.exec("pm clear $packageName")
                } catch (e: Exception) {
                    e.printStackTrace()
                }

//                requireActivity().finishAndRemoveTask()
            }
            dialog.setNegativeButton("خیر", null)
            dialog.setMessage("خروج از حساب کاربری؟")
            dialog.show()
        }

        binding.etEditUserBank.setOnClickListener {
            bottomNav.visibility = View.INVISIBLE
            btnHome.visibility = View.INVISIBLE
            findNavController().navigate(R.id.editBankInfoFragment)
        }

        binding.etEditUser.setOnClickListener {
            bottomNav.visibility = View.INVISIBLE
            btnHome.visibility = View.INVISIBLE
            findNavController().navigate(R.id.editUserInfoFragment)
        }

    }

    private fun observe() {
        val progressBar =
            requireActivity().findViewById<ProgressBar>(com.e.instamarket.R.id.progressBar)
        viewModel.user.observe(viewLifecycleOwner, {
            when (it) {

                is Result.Success -> {
                    binding.userBankRecycler.adapter = ProfileBankAdapter(it.data)
                    binding.profileRecycler.adapter = ProfileInfoAdapter(it.data)
                    progressBar.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)


                }

                is Result.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    requireActivity().window.setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
                }

                is Result.Error -> {
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }


            }
        })
    }


}