package com.e.instamarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.databinding.FragmentEditUserInfoBinding
import com.e.instamarket.viewmodel.user.UserViewModel

class EditUserInfoFragment : Fragment() {

    private lateinit var binding: FragmentEditUserInfoBinding
    private lateinit var viewModel: UserViewModel

    private var firstName = ""
    private var lastName = ""
    private var email = ""
    private var username = ""
    private var phone = ""
//    private var birthday = ""
//    private var education = ""
//    private var marry = ""
//    private var sex = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentEditUserInfoBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveUserInfo.setOnClickListener {

            firstName = binding.etFirstName.text.toString()
            lastName = binding.etLastName.text.toString()
            email = binding.etEmail.text.toString()
            username = binding.etUsername.text.toString()
            phone = binding.etPhone.text.toString()
//            birthday = binding.etBirthday.text.toString()
//            education = binding.etEducate.text.toString()
//            marry = binding.etMarry.text.toString()
//            sex = binding.etSex.text.toString()

            if (
                firstName.isEmpty() ||
                lastName.isEmpty() ||
                email.isEmpty() ||
                username.isEmpty() ||
                phone.isEmpty()
//                birthday.isEmpty() ||
//                education.isEmpty() ||
//                marry.isEmpty() ||
//                sex.isEmpty()
            ) {
                Toast.makeText(
                    requireContext(),
                    "لطفا تمامی مقادیر را تکمیل کنید",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                viewModel.updateUserInfo(
                    firstName,
                    lastName,
                    email,
                    username,
                    phone
//                    birthday,
//                    education,
//                    marry,
//                    sex
                )
                observe()
            }
        }

    }

    private fun observe() {
        val progressBar =
            requireActivity().findViewById<ProgressBar>(com.e.instamarket.R.id.progressBar)
        viewModel.userInfo.observe(viewLifecycleOwner, {
            when (it) {

                is Result.Success -> {
                    if (it.data) {
                        Toast.makeText(
                            requireActivity(),
                            "تغییرات با موفقیت ذخیره شد",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            requireActivity(),
                            "مشکلی پیش آمده لطفا بعدا دوباره امتحان کنید",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    progressBar.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }

                is Result.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    requireActivity().window.setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
                }

                is Result.Error -> {
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.INVISIBLE
                    requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }


            }
        })
    }

}