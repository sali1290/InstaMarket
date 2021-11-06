package com.e.instamarket.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.e.data.utile.SessionManager
import com.e.domain.Result
import com.e.domain.models.RegisterResponseModel
import com.e.domain.models.TokenModel
import com.e.instamarket.R
import com.e.instamarket.databinding.FragmentRegisterBinding
import com.e.instamarket.viewmodel.enterApp.EnterAppViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    lateinit var viewModel: EnterAppViewModel
    private lateinit var sessionManager: SessionManager

    private lateinit var fName: String
    private lateinit var lName: String
    private lateinit var email: String
    private lateinit var username: String
    private lateinit var phone: String
    private lateinit var pass: String
    private lateinit var rePass: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(
            EnterAppViewModel::class.java
        )
        sessionManager = SessionManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button2.setOnClickListener {

            fName = binding.etFirstName.text.toString()
            lName = binding.etLastName.text.toString()
            email = binding.etEmail.text.toString()
            username = binding.etUsername.text.toString()
            phone = binding.etPhone.text.toString()
            pass = binding.etPass.text.toString()
            rePass = binding.etRePass.text.toString()

            if (binding.etFirstName.text.isEmpty() ||
                binding.etLastName.text.isEmpty() ||
                binding.etEmail.text.isEmpty() ||
                binding.etUsername.text.isEmpty() ||
                binding.etPhone.text.isEmpty() ||
                binding.etPass.text.isEmpty() ||
                binding.etRePass.text.isEmpty()
            ) {
                Toast.makeText(
                    requireActivity(),
                    "لطفا تمامی مقادیر را وارد کنید",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (binding.etPass.text.toString() == binding.etRePass.text.toString()) {
                    viewModel.register(email, phone, fName, lName, username, pass, rePass)
                    observe()
                } else {
                    Toast.makeText(
                        requireActivity(),
                        "رمز عبور با تایید مطابقت ندارد",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }

    private fun observe() {
        viewModel.registerResponse.observe(viewLifecycleOwner, {

            when (it) {
                is Result.Success -> {
                    sessionManager.saveAuthToken(it.data.accessToken!!)
                    checkData(it.data)

                }

                is Result.Loading -> {
                    Toast.makeText(requireActivity(), "Loading", Toast.LENGTH_SHORT).show()
                }

                is Result.Error -> {
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_SHORT).show()
                    binding.tvRegisterEmail.text = "پست الکترونیک قبلا استفاده شده است"
                    binding.tvRegisterEmail.setTextColor(requireActivity().getColor(R.color.red))

                    binding.tvRegisterUsername.text = "نام کاربری قبلا استفاده شده است"
                    binding.tvRegisterUsername.setTextColor(requireActivity().getColor(R.color.red))

                    binding.tvRegisterPhone.text = "شماره تلفن قبلا استفاده شده است"
                    binding.tvRegisterPhone.setTextColor(requireActivity().getColor(R.color.red))
                }
            }


        })
    }

    private fun checkData(token: RegisterResponseModel) {
        if (!token.accessToken.isNullOrEmpty()) {
            Toast.makeText(requireActivity(), "خوش آمدید", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.homeFragment)
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, false) {
            }
        } else {
            Toast.makeText(
                requireActivity(),
                token.errors?.email?.get(0),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

