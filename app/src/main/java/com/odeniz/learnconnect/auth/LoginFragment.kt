package com.odeniz.learnconnect.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.odeniz.learnconnect.HomeActivity
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.loginBtnAction.setOnClickListener {
            val email = binding.loginEmailInput.text.toString()
            val password = binding.loginPasswordInput.text.toString()
            viewModel.login(email, password)
        }

        observeRegisterState()
    }

    private fun observeRegisterState() {
        viewModel.loginState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UserState.Success -> {
                    binding.errorTextView.visibility = View.GONE
                    binding.loginProgress.visibility = View.GONE
                    Toast.makeText(
                        context,
                        getString(R.string.welcome),
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(requireContext(), HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    requireActivity().finish()
                }

                is UserState.Error -> {
                    binding.errorTextView.visibility = View.VISIBLE
                    binding.errorTextView.text = state.message
                    binding.loginBtnAction.isEnabled = true
                    binding.loginProgress.visibility = View.GONE
                }

                is UserState.Loading -> {
                    binding.errorTextView.visibility = View.GONE
                    binding.loginProgress.visibility = View.VISIBLE
                    binding.loginBtnAction.isEnabled = false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}