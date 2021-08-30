package com.e.instamarket.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.e.data.di.ApiModule
import com.e.domain.models.ApiModel
import com.e.domain.models.TokenModel
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
        email = "arz1379n@gmail.com"
        password = "sali1290"

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button.setOnClickListener {
            viewModel.login(email, password).observe(viewLifecycleOwner , Observer {
                token = it.value!!
            })
                Toast.makeText(requireContext() , token?.id.toString() , Toast.LENGTH_SHORT).show()
        }


    }






}