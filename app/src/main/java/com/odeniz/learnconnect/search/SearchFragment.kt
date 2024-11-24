package com.odeniz.learnconnect.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.odeniz.learnconnect.adapter.CourseAdapter
import com.odeniz.learnconnect.adapter.ListViewAdapter
import com.odeniz.learnconnect.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "query"

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var param1: String? = null
    private val viewModel: SearchViewModel by viewModels()
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private var courseAdapterVertical: CourseAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        setUpUI()
        observeData()
    }

    private fun setUpUI() {
        binding.recyclerViewVertical.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        param1?.let {
            binding.searchEditView.setQuery(it, true)
        }

        binding.searchEditView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    if (it.length > 2) {
                        viewModel.searchInDatabase(it)
                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                when {
                    newText.isNullOrEmpty() -> {
                        courseAdapterVertical?.clear()
                        binding.recyclerViewVertical.visibility = View.GONE
                        binding.searchProgress.visibility = View.GONE
                        binding.errorTextView.visibility = View.GONE
                        binding.listViewCategories.visibility = View.VISIBLE
                    }

                    newText.length > 2 -> {
                        viewModel.searchInDatabase(newText)
                        binding.listViewCategories.visibility = View.GONE
                    }
                }
                return true
            }
        })
    }

    private fun observeData() {
        viewModel.getCategories()

        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {

                is SearchState.Success -> {
                    binding.searchProgress.visibility = View.GONE
                    binding.errorTextView.visibility = View.GONE
                    val adapter = ListViewAdapter(state.category) {
                        val action =
                            SearchFragmentDirections.actionSearchFragmentToCategoryItemsFragment(it)
                        findNavController().navigate(action)
                    }
                    binding.listViewCategories.adapter = adapter
                }

                is SearchState.SuccessSearch -> {
                    courseAdapterVertical = CourseAdapter(state.courses.toMutableList()) { course ->
                        val action =
                            SearchFragmentDirections.actionSearchFragmentToDetailFragment(course)
                        findNavController().navigate(action)
                    }
                    binding.recyclerViewVertical.adapter = courseAdapterVertical
                    binding.searchProgress.visibility = View.GONE
                    binding.errorTextView.visibility = View.GONE
                    binding.recyclerViewVertical.visibility = View.VISIBLE
                }

                is SearchState.Error -> {
                    binding.errorTextView.apply {
                        text = state.message
                        visibility = View.VISIBLE
                    }
                    binding.recyclerViewVertical.visibility = View.GONE
                    binding.searchProgress.visibility = View.GONE
                }

                is SearchState.Loading -> {
                    binding.searchProgress.visibility = View.VISIBLE
                    binding.errorTextView.visibility = View.GONE
                    binding.recyclerViewVertical.visibility = View.GONE
                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}