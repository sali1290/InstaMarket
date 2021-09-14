package com.e.instamarket.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.addCallback
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.core.view.size
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.e.data.utile.SessionManager
import com.e.instamarket.R
import com.e.instamarket.adapter.EnterAppViewPagerAdapter
import com.e.instamarket.databinding.FragmentEnterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EnterFragment : Fragment() {

    private lateinit var binding: FragmentEnterBinding
    private lateinit var sessionManager: SessionManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEnterBinding.inflate(inflater, container, false)

        sessionManager = SessionManager(requireContext())
        if (!sessionManager.fetchAuthToken().isNullOrEmpty()) {
            findNavController().navigate(R.id.homeFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }

        binding.viewpager.adapter = EnterAppViewPagerAdapter(requireActivity())

        val slidingImageDots: MutableList<ImageView> = ArrayList()
        for (i in 0 until 4) {
            slidingImageDots.add(ImageView(requireContext()))
            slidingImageDots[i].setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.inactive_dot_viewpager
                )
            )

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            binding.sliderDots.addView(slidingImageDots[i], params)
        }
        slidingImageDots[0].setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.active_dot_viewpager
            )
        )

        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                for (i in 0 until 4) {
                    slidingImageDots[i].setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.inactive_dot_viewpager
                        )
                    )
                }
                slidingImageDots[binding.viewpager.currentItem].setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.active_dot_viewpager)
                )
                super.onPageSelected(position)
            }
        })
    }
}









