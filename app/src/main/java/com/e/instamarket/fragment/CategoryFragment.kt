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
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.domain.models.CategoryModel
import com.e.instamarket.databinding.FragmentCategoryBinding
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel
import com.e.instamarket.viewmodel.order.OrderViewModel
import com.google.android.material.snackbar.Snackbar

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
            } else if (quantity.toInt() > 100) {
                Toast.makeText(
                    requireContext(),
                    "تعداد انتخاب شده بیشتر از میزان مجاز است",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "لطفا تمامی مقادیر را تکمیل کنید",
                    Toast.LENGTH_LONG
                ).show()
            }


        }

    }

    private fun observeCategory() {
        val progressBar =
            requireActivity().findViewById<ProgressBar>(com.e.instamarket.R.id.progressBar)
        viewModel.category.observe(viewLifecycleOwner, {
            when (it) {
                is Result.Success -> {
                    val list: MutableList<CategoryModel> = mutableListOf()
                    val nameList: MutableList<String> = mutableListOf()

                    for (i in 0 until it.data.size) {
                        list.add(it.data[i])
                    }
                    list.sortBy {
                        it.sort?.toInt()
                    }

                    for (i in 0 until list.size) {
                        nameList.add(list[i].name!!)
                    }

                    binding.spinner.adapter =
                        ArrayAdapter(
                            requireActivity(),
                            R.layout.simple_dropdown_item_1line,
                            nameList
                        )

                    binding.spinner.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                p0: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val name = list[position].name
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
                    progressBar.visibility = View.VISIBLE
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
        val progressBar =
            requireActivity().findViewById<ProgressBar>(com.e.instamarket.R.id.progressBar)
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
                                        binding.tvServicePrice.text = it.data[i].price + " تومان"
                                        binding.button3.isClickable = true
                                    }
                                }
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }
                        }

                    progressBar.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }
                is Result.Loading -> {
//                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.VISIBLE
                }
                is Result.Error -> {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun observeOrder() {
        val progressBar =
            requireActivity().findViewById<ProgressBar>(com.e.instamarket.R.id.progressBar)
        orderViewModel.order.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {

                    progressBar.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

                    Toast.makeText(
                        requireContext(),
                        it.data.message,
                        Toast.LENGTH_LONG
                    ).show()
                }

                is Result.Loading -> {
//                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.VISIBLE
                    requireActivity().window.setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
                }

                is Result.Error -> {
                    Log.i("my tag", it.message)
                    progressBar.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    Snackbar.make(
                        progressBar,
                        "موجودی شما کافی نیست، لطفا از قسمت افزایش موجودی، موجودی خود را افزایش دهید",
                        Snackbar.LENGTH_LONG
                    ).show()
                }

            }


        })

    }
}