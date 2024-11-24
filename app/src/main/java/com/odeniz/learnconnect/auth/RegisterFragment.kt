package com.odeniz.learnconnect.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.odeniz.learnconnect.HomeActivity
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.databinding.FragmentRegisterBinding
import com.odeniz.learnconnect.model.UserDto
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment: Fragment() {

    private val viewModel: RegisterViewModel by viewModels()
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backLoginAction.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        binding.registerBtnAction.setOnClickListener {
            val fullName = binding.loginFullNameInput.text.toString()
            val email = binding.loginEmailInput.text.toString()
            val password = binding.loginPasswordInput.text.toString()
            val passwordVerify = binding.loginPasswordVerifyInput.text.toString()
            viewModel.insertUser(
                UserDto(
                    email = email,
                    password = password,
                    fullName = fullName,
                    passwordVerify = passwordVerify
                )
            )
        }

        observeRegisterState()
    }

    private fun observeRegisterState() {
        viewModel.registerState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UserState.Success -> {
                    binding.errorTextView.visibility = View.GONE
                    binding.registerProgress.visibility = View.GONE
                    Toast.makeText(
                        context,
                        getString(R.string.welcome),
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(requireContext(), HomeActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                    startActivity(intent)
                    requireActivity().finish()
                }

                is UserState.Error -> {
                    binding.errorTextView.visibility = View.VISIBLE
                    binding.errorTextView.text = state.message
                    binding.registerBtnAction.isEnabled = true
                    binding.registerProgress.visibility = View.GONE
                }

                is UserState.Loading -> {
                    binding.errorTextView.visibility = View.GONE
                    binding.registerProgress.visibility = View.VISIBLE
                    binding.registerBtnAction.isEnabled = false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}