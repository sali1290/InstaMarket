package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.e.instamarket.R
import com.e.instamarket.databinding.FragmentBlogBinding
import com.e.instamarket.viewmodel.user.UserViewModel
import com.e.domain.Result
import com.e.instamarket.adapter.BlogAdapter


class BlogFragment : Fragment() {

    private lateinit var binding: FragmentBlogBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentBlogBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBlogs()
        observe()
    }

    private fun observe() {
        viewModel.blogList.observe(viewLifecycleOwner, {
            when (it) {

                is Result.Success -> {
                    binding.blogRecycler.adapter = BlogAdapter(it.data)
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