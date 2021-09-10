package com.e.instamarket.fragment

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.adapter.AgentAdapter
import com.e.instamarket.databinding.FragmentAgentBinding
import com.e.instamarket.viewmodel.appInfo.AppInfoViewModel

class AgentFragment : Fragment() {

    private lateinit var binding: FragmentAgentBinding
    private lateinit var viewModel: AppInfoViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentAgentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(AppInfoViewModel::class.java)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAgent()
        observe()
    }

    private fun observe() {
        viewModel.agentList.observe(viewLifecycleOwner, {

            when (it) {

                is Result.Success -> {
                    binding.agentRecycler.adapter = AgentAdapter(it.data, requireContext())
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
