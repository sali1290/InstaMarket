package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.e.data.utile.SessionManager
import com.e.instamarket.R
import com.e.instamarket.adapter.EnterAppViewPagerAdapter
import com.e.instamarket.databinding.FragmentEnterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EnterFragment : Fragment() {

    private lateinit var binding: FragmentEnterBinding
    private lateinit var sessionManager: SessionManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEnterBinding.inflate(inflater, container, false)

        sessionManager = SessionManager(requireContext())
        if (!sessionManager.fetchAuthToken().isNullOrEmpty()) {
            findNavController().navigate(R.id.homeFragment)
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, false) {
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewpager.adapter = EnterAppViewPagerAdapter(requireActivity())


        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }
    }
}

