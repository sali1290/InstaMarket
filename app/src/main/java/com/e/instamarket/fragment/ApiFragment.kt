package com.e.instamarket.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.adapter.ApiAdapter
import com.e.instamarket.databinding.FragmentApiBinding
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel
import okhttp3.internal.notify


class ApiFragment : Fragment() {

    private lateinit var binding: FragmentApiBinding
    private lateinit var viewModel: AppInfoViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentApiBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(AppInfoViewModel::class.java)
        observe()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getApi()
    }

    private fun observe() {

        viewModel.apiList.observe(viewLifecycleOwner, {

            when (it) {
                is Result.Success -> {
                    Toast.makeText(requireContext(), it.data[0].name , Toast.LENGTH_SHORT).show()
                    binding.apiRecycler.adapter = ApiAdapter(it.data, requireContext())
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