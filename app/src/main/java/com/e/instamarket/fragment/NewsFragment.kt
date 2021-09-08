package com.e.instamarket.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.adapter.NewsAdapter
import com.e.instamarket.databinding.FragmentNewsBinding
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel


class NewsFragment : Fragment() {

    lateinit var binding: FragmentNewsBinding
    lateinit var viewModel: AppInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentNewsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(AppInfoViewModel::class.java)
        observe()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNews()

    }

    private fun observe() {
        viewModel.news.observe(viewLifecycleOwner, {
            when (it) {

                is Result.Success -> {
                    binding.newsRecycler.adapter = NewsAdapter(it.data)
                }

                is Result.Loading -> {
                    Toast.makeText(requireActivity(), "Loading", Toast.LENGTH_SHORT).show()
                }

                is Result.Error -> {
                    Toast.makeText(requireActivity(), it.message , Toast.LENGTH_SHORT).show()
                }
            }


        })


    }


}