package com.e.instamarket.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.e.data.di.ApiModule
import com.e.domain.models.ApiModel
import com.e.domain.models.TokenModel
import com.e.instamarket.R
import com.e.instamarket.databinding.FragmentLoginBinding
import com.e.instamarket.viewmodel.enterApp.EnterAppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment() : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: EnterAppViewModel
    lateinit var email: String
    lateinit var password: String
    var token: TokenModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(
            EnterAppViewModel::class.java
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button.setOnClickListener {
            email = binding.etUsername.text.toString()
            password = binding.etPassword.text.toString()

            if (email.isEmpty()) {
                binding.tvUsername.setText("لطفا ایمیل خود را وارد کنید")
                binding.tvUsername.setTextColor(resources.getColor(R.color.red))
            } else if (password.isEmpty()) {
                binding.tvPassword.setText("لطفا رمزعبور را وارد کنید")
                binding.tvPassword.setTextColor(resources.getColor(R.color.red))
            } else {
                observe()
                observe()
                findNavController().navigate(R.id.homeFragment)
            }

        }


    }

    private fun observe() {
        viewModel.login(email, password).observe(viewLifecycleOwner, Observer {
            token = it.value!!
        })
    }


}