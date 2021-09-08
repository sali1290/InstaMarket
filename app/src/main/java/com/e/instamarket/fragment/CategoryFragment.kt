package com.e.instamarket.fragment

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.databinding.FragmentCategoryBinding
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel
import java.text.FieldPosition

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private lateinit var viewModel: AppInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(AppInfoViewModel::class.java)
        viewModel.getCategory()
        viewModel.getService()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.serviceSpinner.isClickable = false
        binding.button3.isClickable = false
        observeCategory()

    }

    private fun observeCategory() {
        viewModel.category.observe(viewLifecycleOwner, {
            when (it) {
                is Result.Success -> {
                    val list: MutableList<String> = arrayListOf()
                    for (i in 0 until it.data.size) {
                        list.add(it.data[i].name!!)
                    }
                    binding.spinner.adapter =
                        ArrayAdapter(requireActivity(), R.layout.simple_dropdown_item_1line, list)

                    binding.spinner.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                p0: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val name = list[position]
                                for (i in 0 until list.size) {
                                    if (name == it.data[i].name) {
                                        observeService(it.data[i].id!!)
                                    }
                                }
                                binding.serviceSpinner.isClickable = true
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }
                        }


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

    private fun observeService(id: Int) {
        viewModel.service.observe(viewLifecycleOwner, {
            when (it) {
                is Result.Success -> {
                    val list: MutableList<String> = arrayListOf()
                    for (i in 0 until it.data.size) {
                        if (it.data[i].cateId.equals(id.toString())) {
                            list.add(it.data[i].name!!)
                        }
                    }
                    binding.serviceSpinner.adapter =
                        ArrayAdapter(requireActivity(), R.layout.simple_dropdown_item_1line, list)

                    binding.serviceSpinner.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                p0: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val name = list[position]
                                for (i in 0 until list.size) {
                                    if (name == it.data[i].name) {
                                        binding.tvDescription.text = it.data[i].desc.toString()
                                    }
                                }
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }
                        }


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