package com.odeniz.learnconnect.profile

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels()
    private var selectedUri: Bitmap? = null
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.profile()

        binding.saveChangesBtnAction.setOnClickListener {
            val userName = binding.fullNameEditText.text.toString()
            val mail = binding.mailEditText.text.toString()
            val about = binding.aboutEditText.text.toString()
            try {
                lifecycleScope.launch {
                    withContext(Dispatchers.IO) {
                        viewModel.updateProfile(userName, mail, about, selectedUri)
                    }
                }
                Toast.makeText(requireContext(), getString(R.string.saved), Toast.LENGTH_SHORT)
                    .show()
            } catch (e: Exception) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.unknown_error),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.profileImageView.setOnClickListener {
            checkAndRequestPermissions()
        }
        observeStates()

    }

    private fun observeStates() {
        viewModel.profileState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ProfileState.Success -> {
                    binding.apply {
                        user = state.user
                    }
                    binding.saveChangesBtnAction.isEnabled = true
                    binding.profileProgress.visibility = View.GONE
                    binding.errorTextView.visibility = View.GONE
                }

                is ProfileState.Error -> {
                    binding.errorTextView.visibility = View.VISIBLE
                    binding.errorTextView.text = state.message
                    binding.saveChangesBtnAction.isEnabled = true
                    binding.profileProgress.visibility = View.GONE
                }

                is ProfileState.Loading -> {
                    binding.errorTextView.visibility = View.GONE
                    binding.profileProgress.visibility = View.VISIBLE
                    binding.saveChangesBtnAction.isEnabled = false
                }

                is ProfileState.SuccessUpdate -> {
                    binding.saveChangesBtnAction.isEnabled = true
                    binding.profileProgress.visibility = View.GONE
                    binding.errorTextView.visibility = View.GONE
                }
            }
        }
    }

    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                try {
                    val inputStream = requireContext().contentResolver.openInputStream(it)
                    val bitmap = BitmapFactory.decodeStream(inputStream)
                    bindImageToView(bitmap)
                    inputStream?.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(requireContext(), "Failed to load image", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                openGallery()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.permission_denied),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    private fun checkAndRequestPermissions() {
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> {
                // Android 13 ve above
                if (ContextCompat.checkSelfPermission(
                        requireContext(),
                        Manifest.permission.READ_MEDIA_IMAGES
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    requestPermissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
                } else {
                    openGallery()
                }
            }

            else -> {
                // Android 6 - 12
                if (ContextCompat.checkSelfPermission(
                        requireContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                } else {
                    // Android -6
                    openGallery()
                }
            }
        }
    }

    private fun openGallery() {
        pickImageLauncher.launch("image/*")
    }

    private fun bindImageToView(uri: Bitmap) {
        selectedUri = uri
        binding.profileImageView.setImageBitmap(uri)
    }
}