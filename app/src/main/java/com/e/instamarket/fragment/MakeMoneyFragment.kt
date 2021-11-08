package com.e.instamarket.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.e.instamarket.databinding.FragmentMakeMoneyBinding
import com.e.instamarket.viewmodel.enterApp.EnterAppViewModel
import com.e.domain.Result
import com.e.instamarket.R


class MakeMoneyFragment : Fragment() {

    private lateinit var binding: FragmentMakeMoneyBinding
    private lateinit var viewModel: EnterAppViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMakeMoneyBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(EnterAppViewModel::class.java)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser()
        observe()
    }

    private fun observe() {
        val progressBar = requireActivity().findViewById<ProgressBar>(R.id.progressBar)
        viewModel.user.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {
                    binding.tvId.text = it.data.id.toString()
                    progressBar.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }

                is Result.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    requireActivity().window.setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
                }

                is Result.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }


            }

        })
    }

}