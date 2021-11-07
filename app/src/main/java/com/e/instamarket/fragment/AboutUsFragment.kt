package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.e.instamarket.databinding.FragmentAboutUsBinding
import com.e.domain.Result
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel

class AboutUsFragment : Fragment() {

    private lateinit var binding: FragmentAboutUsBinding
    private lateinit var viewModel: AppInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentAboutUsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(AppInfoViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAboutUs()
        observe()
    }


    private fun observe() {
        val progressBar =
            requireActivity().findViewById<ProgressBar>(com.e.instamarket.R.id.progressBar)
        viewModel.aboutUs.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {
                    binding.tvAboutUs.text = it.data.text
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