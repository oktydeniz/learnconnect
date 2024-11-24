package com.odeniz.learnconnect.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.adapter.CourseAdapter
import com.odeniz.learnconnect.databinding.FragmentCourseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseFragment : Fragment() {

    private val viewModel: CourseViewModel by viewModels()
    private var _binding: FragmentCourseBinding? = null
    private lateinit var courseAdapterVertical: CourseAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()

    }

    private fun setUpUI() {
        viewModel.getPurchasedCourses()
        binding.recyclerViewVertical.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UserCourseState.Loading -> {
                    binding.listProgress.visibility = View.VISIBLE
                    binding.errorText.visibility = View.GONE
                    binding.recyclerViewVertical.visibility = View.GONE
                }

                is UserCourseState.Success -> {
                    binding.listProgress.visibility = View.GONE
                    binding.errorText.visibility = View.GONE
                    courseAdapterVertical =
                        CourseAdapter(state.userCourses.toMutableList()) { course ->
                            val action =
                                CourseFragmentDirections.actionCourseFragmentToDetailFragment(course)
                            findNavController().navigate(action)
                        }
                    if (courseAdapterVertical.itemCount == 0) {
                        binding.recyclerViewVertical.visibility = View.GONE
                        binding.errorText.text =
                            getString(R.string.you_have_not_purchased_any_course)
                        binding.errorText.visibility = View.VISIBLE
                    }
                    binding.recyclerViewVertical.adapter = courseAdapterVertical
                    binding.recyclerViewVertical.visibility = View.VISIBLE
                }

                is UserCourseState.Error -> {
                    binding.listProgress.visibility = View.GONE
                    binding.recyclerViewVertical.visibility = View.GONE
                    binding.errorText.text = state.message
                    binding.errorText.visibility = View.VISIBLE
                }
            }
        }
    }
}