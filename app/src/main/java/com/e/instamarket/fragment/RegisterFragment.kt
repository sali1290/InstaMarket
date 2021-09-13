package com.e.instamarket.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.e.data.utile.SessionManager
import com.e.domain.Result
import com.e.domain.models.TokenModel
import com.e.instamarket.R
import com.e.instamarket.databinding.FragmentRegisterBinding
import com.e.instamarket.viewmodel.enterApp.EnterAppViewModel
import dagger.hilt.android.AndroidEntryPoint


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

//            if (binding.etFirstName.text.isEmpty() ||
//                binding.etLastName.text.isEmpty() ||
//                binding.etEmail.text.isEmpty() ||
//                binding.etUsername.text.isEmpty() ||
//                binding.etPhone.text.isEmpty() ||
//                binding.etPass.text.isEmpty() ||
//                binding.etRePass.text.isEmpty()
//            ) {
//                Toast.makeText(
//                    requireActivity(),
//                    "لطفا تمامی مقادیر را وارد کنید",
//                    Toast.LENGTH_SHORT
//                ).show()
//            } else {
                viewModel.register(email, phone, fName, lName, username, pass, rePass)
                observe()
         //   }
        }
    }

    private fun observe() {
        viewModel.token.observe(viewLifecycleOwner, {

            when (it) {
                is Result.Success -> {
                    checkData(it.data)
                    sessionManager.saveAuthToken(it.data.accessToken!!)
                }

                is Result.Loading -> {
                    Toast.makeText(requireActivity(), "Loading", Toast.LENGTH_SHORT).show()
                }

                is Result.Error -> {
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_SHORT).show()
                }
            }


        })
    }

    private fun checkData(token: TokenModel) {
        when {
            !token.errors?.email.isNullOrEmpty() -> {
                Toast.makeText(requireActivity(), token.errors?.email?.get(0)!!, Toast.LENGTH_SHORT)
                    .show()
            }
            !token.errors?.password.isNullOrEmpty() -> {
                Toast.makeText(requireActivity(), token.errors?.password?.get(0)!!, Toast.LENGTH_SHORT)
                    .show()
            }
            else -> {
                findNavController().navigate(R.id.homeFragment)
                requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, false) {
                }
            }
        }
    }

}