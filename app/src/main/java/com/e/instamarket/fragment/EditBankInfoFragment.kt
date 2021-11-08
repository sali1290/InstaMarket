package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.databinding.FragmentEditBankInfoBinding
import com.e.instamarket.viewmodel.user.UserViewModel

class EditBankInfoFragment : Fragment() {

    private lateinit var binding: FragmentEditBankInfoBinding
    private lateinit var viewModel: UserViewModel

    private var shcart = ""
    private var shshaba = ""
    private var bankName = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBankInfoBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveBankInfo.setOnClickListener {

            if (binding.etShcart.text.isEmpty() || binding.etShshaba.text.isEmpty() || binding.etBankName.text.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "لطفا تمامی مقادیر را تکمیل کنید",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                shcart = binding.etShcart.text.toString()
                shshaba = binding.etShshaba.text.toString()
                bankName = binding.etBankName.text.toString()
                viewModel.updateUserBankInfo(shcart, shshaba, bankName)
                observe()


            }


        }


    }

    private fun observe() {
        val progressBar =
            requireActivity().findViewById<ProgressBar>(com.e.instamarket.R.id.progressBar)
        viewModel.updateUserBankInfo.observe(viewLifecycleOwner, {
            when (it) {
                is Result.Success -> {
                    if (it.data) {
                        Toast.makeText(
                            requireActivity(),
                            "تغییرات با موفقیت ذخیره شد",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            requireActivity(),
                            "مشکلی پیش آمده لطفا بعدا دوباره امتحان کنید",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
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
