package com.e.instamarket.fragment

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.databinding.FragmentRaiseStockBinding
import com.e.instamarket.viewmodel.transaction.TransactionViewModel
import com.google.android.material.snackbar.Snackbar

class RaiseStockFragment : Fragment() {

    private lateinit var binding: FragmentRaiseStockBinding
    private lateinit var viewModel: TransactionViewModel

    private var amount = ""
//    private var discount = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentRaiseStockBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(TransactionViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfirm.setOnClickListener {
            amount = binding.etAmount.text.toString()
            if (binding.etAmount.text.isNotEmpty() && binding.checkBox2.isChecked
                && amount.toInt() >= 10000
            ) {

                viewModel.createTransaction(amount, "zarinpal")
                Snackbar.make(
                    binding.btnConfirm,
                    "در حال انتقال به صفحه پذیرنده",
                    Snackbar.LENGTH_LONG
                ).show()
                amount = ""
                binding.etAmount.setText("")
                observe()
            } else {
                val imm =
                    requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
                Snackbar.make(
                    binding.btnConfirm,
                    "مبلغ وارد شده باید بیشتر 10000 تومان باشد",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun observe() {
        val progressBar =
            requireActivity().findViewById<ProgressBar>(com.e.instamarket.R.id.progressBar)
        viewModel.createRequest.observe(viewLifecycleOwner, {

            when (it) {
                is Result.Success -> {
                    progressBar.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.data))
                    startActivity(intent)
                }

                is Result.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    requireActivity().window.setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
                }

                is Result.Error -> {
                    Toast.makeText(
                        requireContext(),
                        "لطفا اتصال اینترنت خود را بررسی کنید",
                        Toast.LENGTH_SHORT
                    ).show()
                    progressBar.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }
            }


        })


    }

}