package com.e.instamarket.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.databinding.FragmentLuckWheelBinding
import com.e.instamarket.viewmodel.luck.LuckViewModel


class LuckWheelFragment : Fragment() {

    private lateinit var binding: FragmentLuckWheelBinding
    private lateinit var viewModel: LuckViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentLuckWheelBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(LuckViewModel::class.java)
        observe()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setLuckWheel()
    }

    private fun observe() {
        viewModel.luckSliceList.observe(viewLifecycleOwner, {

            when (it) {
                is Result.Success -> {





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