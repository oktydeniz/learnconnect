package com.odeniz.learnconnect.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.odeniz.learnconnect.adapter.CourseAdapter
import com.odeniz.learnconnect.databinding.FragmentHomeBinding
import com.odeniz.learnconnect.home.state.HomeState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var courseAdapterHorizontal: CourseAdapter
    private lateinit var courseAdapterVertical: CourseAdapter
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
    }

    private fun setUpUI() {
        binding.recyclerViewHorizontal.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        binding.recyclerViewVertical.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.getForHomePage()

        viewModel.homeState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is HomeState.Success -> {
                    courseAdapterHorizontal = CourseAdapter(state.topCourses.toMutableList()) { course ->
                        val action =
                            HomeFragmentDirections.actionHomeFragmentToDetailFragment2(course)
                        findNavController().navigate(action)
                    }
                    courseAdapterVertical = CourseAdapter(state.newCourses.toMutableList()) { course ->
                        val action =
                            HomeFragmentDirections.actionHomeFragmentToDetailFragment2(course)
                        findNavController().navigate(action)
                    }

                    binding.recyclerViewHorizontal.adapter = courseAdapterHorizontal
                    binding.recyclerViewVertical.adapter = courseAdapterVertical
                    showContent()
                }

                is HomeState.Error -> {
                    showError(state.message)
                }

                is HomeState.Loading -> {
                    showLoading()
                }
            }
        }

    }

    private fun showContent() {
        binding.apply {
            homeProgress.visibility = View.GONE
            homeErrorText.visibility = View.GONE
            recyclerViewHorizontal.visibility = View.VISIBLE
            recyclerViewVertical.visibility = View.VISIBLE
            newCoursesText.visibility = View.VISIBLE
            recommendedText.visibility = View.VISIBLE
        }
    }

    private fun showError(message: String) {
        binding.apply {
            homeErrorText.visibility = View.VISIBLE
            homeErrorText.text = message
            homeProgress.visibility = View.GONE
            recyclerViewHorizontal.visibility = View.GONE
            recyclerViewVertical.visibility = View.GONE
            newCoursesText.visibility = View.GONE
            recommendedText.visibility = View.GONE
        }
    }

    private fun showLoading() {
        binding.apply {
            homeErrorText.visibility = View.GONE
            homeProgress.visibility = View.VISIBLE
            recyclerViewHorizontal.visibility = View.GONE
            recyclerViewVertical.visibility = View.GONE
            newCoursesText.visibility = View.GONE
            recommendedText.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}