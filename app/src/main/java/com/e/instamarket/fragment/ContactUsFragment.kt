package com.e.instamarket.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.e.instamarket.databinding.FragmentContactUsBinding
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel
import com.e.domain.Result


class ContactUsFragment : Fragment() {

    private lateinit var binding: FragmentContactUsBinding
    private lateinit var viewModel: AppInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentContactUsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(AppInfoViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getContactUs()
        observe()
    }

    private fun observe() {
        viewModel.contactUs.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {
                    binding.tvContactUs.text = it.data.text
                }

                is Result.Loading -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                }

                is Result.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }


            }
        })
    }

}