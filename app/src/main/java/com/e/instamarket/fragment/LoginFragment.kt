package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.e.data.entity.Token
import com.e.domain.models.TokenModel
import com.e.domain.usecase.enterAppUseCase.GetUserFromLogin
import com.e.domain.usecase.enterAppUseCase.LoginUseCase
import com.e.instamarket.R
import com.e.instamarket.databinding.FragmentLoginBinding
import com.e.instamarket.viewmodel.enterApp.EnterAppViewModel
import com.e.instamarket.viewmodel.enterApp.EnterAppViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val getUserFromLogin: GetUserFromLogin
) : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: EnterAppViewModel
    lateinit var email: String
    lateinit var password: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(requireActivity()).get(EnterAppViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button.setOnClickListener {
            email = binding.etUsername.text.toString()
            password = binding.etPassword.text.toString()
            observeViewModel(email , password)
        }



    }

    private fun observeViewModel(email: String, password: String){
        viewModel.login(email , password).observe(viewLifecycleOwner , Observer {
        })
    }


}