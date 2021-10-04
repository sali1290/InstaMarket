package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.adapter.FaqAdapter
import com.e.instamarket.databinding.FragmentFaqBinding
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel

class FaqFragment : Fragment() {

    private lateinit var binding: FragmentFaqBinding
    private lateinit var viewModel: AppInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentFaqBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(AppInfoViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFaq()
        observe()
    }

    private fun observe() {
        viewModel.faqList.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {
                    binding.faqRecycler.adapter = FaqAdapter(it.data)
                }

                is Result.Loading -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                }

                is Result.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }

            }


        })
    }

}