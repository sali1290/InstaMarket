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
import com.e.domain.models.TokenModel
import com.e.instamarket.R
import com.e.instamarket.databinding.FragmentLoginBinding
import com.e.instamarket.viewmodel.enterApp.EnterAppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: EnterAppViewModel
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var sessionManager: SessionManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(
            EnterAppViewModel::class.java
        )
        sessionManager = SessionManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button.setOnClickListener {
            email = binding.etUsername.text.toString()
            password = binding.etPassword.text.toString()

            when {
                email.isEmpty() -> {
                    binding.tvUsername.text = "لطفا ایمیل خود را وارد کنید"
                    binding.tvUsername.setTextColor(resources.getColor(R.color.red))
                }
                password.isEmpty() -> {
                    binding.tvPassword.text = "لطفا رمزعبور را وارد کنید"
                    binding.tvPassword.setTextColor(resources.getColor(R.color.red))
                }
                else -> {
                    viewModel.login(email, password)
                    observe()
                }
            }

        }


    }

    private fun observe() {
        viewModel.token.observe(viewLifecycleOwner, {
            when (it) {

                is Result.Success -> {
                    sessionManager.saveAuthToken(it.data.accessToken!!)
                    checkToken(it.data)
                    Toast.makeText(requireActivity(), "خوش آمدید", Toast.LENGTH_SHORT).show()
                }

                is Result.Loading -> {
                    Toast.makeText(requireActivity(), "Loading", Toast.LENGTH_SHORT).show()
                }

                is Result.Error -> {
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_SHORT).show()
                }
                else -> {

                }
            }
        })
    }

    private fun checkToken(token: TokenModel) {
        if (!token.accessToken.isNullOrEmpty()) {
            findNavController().navigate(R.id.homeFragment)
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, false) {
            }
        } else {
            Toast.makeText(
                requireActivity(),
                "نام کاربری یا رمز عبور اشتباه است",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}