package com.odeniz.learnconnect.wishlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.adapter.CourseAdapter
import com.odeniz.learnconnect.databinding.FragmentWishListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WishListFragment : Fragment() {

    private val viewModel: WishListViewModel by viewModels()
    private lateinit var courseAdapterVertical: CourseAdapter
    private var _binding: FragmentWishListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        observeData()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getUserList()
    }

    private fun observeData() {
        viewModel.state.observe(viewLifecycleOwner) { state ->

            when (state) {
                is WishlistState.Success -> {
                    courseAdapterVertical = CourseAdapter(state.courses.toMutableList()) { course ->
                        val action =
                            WishListFragmentDirections.actionWishListFragmentToDetailFragment2(
                                course
                            )
                        findNavController().navigate(action)
                    }
                    if (courseAdapterVertical.itemCount == 0) {
                        binding.recyclerViewVertical.visibility = View.GONE
                        binding.listProgress.visibility = View.GONE
                        binding.errorText.apply {
                            visibility = View.VISIBLE
                            text = resources.getString(R.string.empty_wishlist)
                        }
                    } else {
                        binding.recyclerViewVertical.apply {
                            adapter = courseAdapterVertical
                            visibility = View.VISIBLE
                        }
                        binding.errorText.visibility = View.GONE
                        binding.listProgress.visibility = View.GONE
                    }
                }

                is WishlistState.Error -> {
                    binding.recyclerViewVertical.visibility = View.GONE
                    binding.errorText.apply {
                        visibility = View.VISIBLE
                        text = state.message
                    }
                }

                is WishlistState.Loading -> {
                    binding.recyclerViewVertical.visibility = View.GONE
                    binding.errorText.visibility = View.GONE
                    binding.listProgress.visibility = View.VISIBLE
                }
            }

        }
    }

    private fun setUpUI() {
        binding.recyclerViewVertical.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        viewModel.getUserList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}