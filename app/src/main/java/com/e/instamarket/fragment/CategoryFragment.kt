package com.e.instamarket.fragment

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.databinding.FragmentCategoryBinding
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel
import com.e.instamarket.viewmodel.order.OrderViewModel

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private lateinit var viewModel: AppInfoViewModel
    private lateinit var orderViewModel: OrderViewModel

    private var categoryId: String = ""
    private var serviceId: String = ""
    private var quantity: String = ""
    private var link: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(AppInfoViewModel::class.java)
        viewModel.getCategory()
        viewModel.getService()

        orderViewModel = ViewModelProvider(requireActivity()).get(OrderViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.serviceSpinner.isClickable = false
        binding.button3.isClickable = false
        observeCategory()

        binding.button3.setOnClickListener {

            link = binding.textView16.text.toString()
            quantity = binding.quantityField.text.toString()

            if (categoryId != "" && serviceId != "" && link != "" && quantity != "" && binding.checkBox.isChecked) {
                orderViewModel.createOrder(categoryId, serviceId, quantity, link)
                observeOrder()
            } else {
                Toast.makeText(
                    requireContext(),
                    "please fill all: \n$categoryId \n$serviceId \n$quantity \n$link ",
                    Toast.LENGTH_LONG
                ).show()
            }


        }

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
                                        categoryId = it.data[i].id.toString()
                                    }
                                }
                                binding.serviceSpinner.isClickable = true
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }
                        }


                }
                is Result.Loading -> {
//                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                    binding.categoryProgress.visibility = View.VISIBLE
                    requireActivity().window.setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
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
                                for (i in 0 until it.data.size) {
                                    if (name == it.data[i].name) {
                                        serviceId = it.data[i].id.toString()
                                        binding.button3.isClickable = true
                                    }
                                }
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }
                        }

                    binding.categoryProgress.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }
                is Result.Loading -> {
//                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                    binding.categoryProgress.visibility = View.VISIBLE
                }
                is Result.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun observeOrder() {
        orderViewModel.order.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {

                    binding.categoryProgress.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

                    Toast.makeText(
                        requireContext(),
                        "Succeed " + it.data.message,
                        Toast.LENGTH_LONG
                    ).show()
                    Log.i("my tag", it.data.message!!)
                }

                is Result.Loading -> {
//                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                    binding.categoryProgress.visibility = View.VISIBLE
                    requireActivity().window.setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
                }

                is Result.Error -> {
                    Log.i("my tag", it.message)
                }

            }


        })

    }
}