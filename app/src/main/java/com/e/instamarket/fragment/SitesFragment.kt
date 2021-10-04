package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.e.domain.Result
import androidx.lifecycle.ViewModelProvider
import com.e.instamarket.adapter.SitesAdapter
import com.e.instamarket.databinding.FragmentSitesBinding
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel

class SitesFragment : Fragment() {

    private lateinit var binding: FragmentSitesBinding
    private lateinit var viewModel: AppInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentSitesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(AppInfoViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getSites()
        observe()

    }

    private fun observe() {
        viewModel.siteList.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {
                    binding.siteRecycler.adapter = SitesAdapter(it.data , requireContext())
                }

                is Result.Loading -> {
                    Toast.makeText(requireContext(), "Loading" , Toast.LENGTH_LONG).show()
                }

                is Result.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }

            }
        })
    }


}