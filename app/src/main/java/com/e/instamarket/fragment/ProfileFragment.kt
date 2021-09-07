package com.e.instamarket.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.databinding.FragmentProfileBinding
import com.e.instamarket.viewmodel.user.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        observe()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser()
    }

    private fun observe() {
        viewModel.user.observe(viewLifecycleOwner, {
            when (it) {

                is Result.Success -> {
                    binding.apply {
                        tvName1.text = "نام"
                        tvName2.text = "نام خانوادگی"
                        tvName3.text = "ایمیل"
                        tvName4.text = "نام کاربری"
                        tvName5.text = "شماره تلفن"
                        tvName6.text = "شماره کارت"
                        tvName7.text = "شماره شبا"
                        tvName8.text = "بانک"
                        tvName9.text = "تاریخ تولد"
                        tvName10.text = "تحصیلات"
                        tvName11.text = "وضعیت تاهل"
                        tvName12.text = "جنسیت"

                        etName1.text = it.data.firstName
                        etName2.text = it.data.lastName
                        etName3.text = it.data.email
                        etName4.text = it.data.userName
                        etName5.text = it.data.phone
                        etName6.text = it.data.cardNumber
                        etName7.text = it.data.shNumber
                        etName8.text = it.data.bankName
                        etName9.text = it.data.birthday
                        etName10.text = it.data.education
                        etName11.text = it.data.marry
                        etName12.text = it.data.sex
                    }

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