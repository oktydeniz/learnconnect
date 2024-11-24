package com.odeniz.learnconnect.search

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.adapter.CourseAdapter
import com.odeniz.learnconnect.databinding.FragmentCategoryItemsBinding
import com.odeniz.learnconnect.entity.Category
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "category"

@AndroidEntryPoint
class CategoryItemsFragment : Fragment() {

    private var categoryId: Category? = null
    private val viewModel: CategoryItemsViewModel by viewModels()
    private lateinit var courseAdapterVertical: CourseAdapter
    private var _binding: FragmentCategoryItemsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            categoryId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getSerializable(ARG_PARAM1, Category::class.java)
            } else {
                it.getSerializable(ARG_PARAM1) as Category?
            }
        }
        setUpUI()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideBottomBar()
    }


    override fun onResume() {
        super.onResume()
       hideBottomBar()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setUpUI() {
        categoryId?.let {
            viewModel.getCourses(it.id)
        }
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is SearchState.SuccessSearch -> {
                    binding.homeProgress.visibility = View.GONE
                    binding.homeErrorText.visibility = View.GONE
                    courseAdapterVertical = CourseAdapter(state.courses.toMutableList()) { course ->
                        val action =
                            CategoryItemsFragmentDirections.actionCategoryItemsFragmentToDetailFragment(
                                course
                            )
                        findNavController().navigate(action)
                    }
                    binding.recyclerViewVertical.adapter = courseAdapterVertical
                    binding.recyclerViewVertical.visibility = View.VISIBLE
                }

                is SearchState.Error -> {
                    binding.homeErrorText.apply {
                        text = state.message
                        visibility = View.VISIBLE
                    }
                    binding.recyclerViewVertical.visibility = View.GONE
                    binding.homeProgress.visibility = View.GONE
                }

                is SearchState.Loading -> {
                    binding.homeProgress.visibility = View.VISIBLE
                    binding.homeErrorText.visibility = View.GONE
                    binding.recyclerViewVertical.visibility = View.GONE
                }
                else -> {}
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        showBottomBar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showBottomBar() {
        val bottomBar = requireActivity().findViewById<View>(R.id.main_bottom_nav)
        bottomBar.visibility = View.VISIBLE
    }

    private fun hideBottomBar() {
        val bottomBar = requireActivity().findViewById<View>(R.id.main_bottom_nav)
        bottomBar.visibility = View.GONE
    }

}