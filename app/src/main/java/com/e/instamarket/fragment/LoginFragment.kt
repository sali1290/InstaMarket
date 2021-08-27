package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.liveData
import androidx.navigation.fragment.findNavController
import com.e.data.entity.Token
import com.e.domain.usecase.enterAppUseCase.GetUserFromLogin
import com.e.domain.usecase.enterAppUseCase.LoginUseCase
import com.e.instamarket.R
import com.e.instamarket.databinding.FragmentLoginBinding

class LoginFragment(
    private val loginUseCase: LoginUseCase,
    private val getUserFromLogin: GetUserFromLogin
) : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val username: String = binding.etUsername.text.toString()
            val password: String = binding.etPassword.text.toString()


        }

    }


}