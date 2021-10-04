package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.adapter.OrdersAdapter
import com.e.instamarket.databinding.FragmentOrdersBinding
import com.e.instamarket.viewmodel.order.OrderViewModel

class OrdersFragment : Fragment() {

    private lateinit var binding: FragmentOrdersBinding
    private lateinit var viewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentOrdersBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(OrderViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getOrder(0)
        observe()

    }

    private fun observe() {
        viewModel.orderList.observe(viewLifecycleOwner, {
            when (it) {

                is Result.Success -> {
                    binding.orderListRecycler.adapter = OrdersAdapter(it.data)
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