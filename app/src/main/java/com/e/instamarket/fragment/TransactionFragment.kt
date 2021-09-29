package com.e.instamarket.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.e.domain.Result
import androidx.lifecycle.ViewModelProvider
import com.e.instamarket.adapter.TransactionAdapter
import com.e.instamarket.databinding.FragmentTransactionBinding
import com.e.instamarket.viewmodel.transaction.TransactionViewModel


class TransactionFragment : Fragment() {

    private lateinit var binding: FragmentTransactionBinding
    private lateinit var viewModel: TransactionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentTransactionBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(TransactionViewModel::class.java)
        viewModel.getTransactions("1250")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()


    }

    private fun observe() {
        viewModel.transactionList.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {
                    Log.v("tag", "sdfsdfsd55555")
                    binding.transactionRecycler.adapter =
                        TransactionAdapter(it.data, requireContext())
                }

                is Result.Loading -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                }

                is Result.Error -> {
                    Log.i("My Tag", it.message)
                }
            }
        })


    }


}
