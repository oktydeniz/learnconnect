package com.odeniz.learnconnect.home

import android.content.Intent
import android.content.res.Resources.Theme
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.adapter.VideoListAdapter
import com.odeniz.learnconnect.databinding.FragmentDetailBinding
import com.odeniz.learnconnect.entity.Course
import com.odeniz.learnconnect.entity.Video
import com.odeniz.learnconnect.home.state.DetailState
import com.odeniz.learnconnect.player.FullScreenPlayerActivity
import com.odeniz.learnconnect.util.DateUtil
import com.odeniz.learnconnect.util.showAlertDialog
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "course"
private const val NOT_ADDED = "not_added"
private const val ADDED = "added"

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val viewModel: DetailViewModel by viewModels()
    private val binding get() = _binding!!
    private var course: Course? = null
    private var canUserOpenVideos = false
    private var courseVideos: List<Video>? = null
    private var lastSeenID: Int? = null
    private lateinit var courseAdapterVertical: VideoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideBottomBar()
    }

    override fun onResume() {
        super.onResume()
        hideBottomBar()
        course?.let {
            viewModel.getLastSeenVideo(it.id)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            course = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getSerializable(ARG_PARAM1, Course::class.java)
            } else {
                it.getSerializable(ARG_PARAM1) as Course?
            }
        }
        setUpUI()
        observeData()
    }

    private fun observeData() {
        canUserOpenVideos = false
        viewModel.detailState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is DetailState.SuccessFindCategory -> {
                    binding.categoryTypeTextView.text = state.category.categoryName
                }

                is DetailState.Error -> {
                    binding.categoryTypeTextView.text = state.message
                }

                is DetailState.PurchaseStatus -> {
                    if (state.isPurchased) {
                        binding.saveToList.visibility = View.GONE
                        canUserOpenVideos = true
                        binding.buyCourseButton.apply {
                            setImageResource(R.drawable.ic_play_circle)
                            setOnClickListener {
                                startToPlayVideos()
                            }
                        }
                    } else if (state.isInWishlist) {
                        binding.saveToList.apply {
                            visibility = View.VISIBLE
                            setImageResource(R.drawable.ic_bookmark_done)
                            tag = ADDED
                        }
                    } else {
                        binding.saveToList.tag = NOT_ADDED
                        canUserOpenVideos = false
                    }
                }

                is DetailState.CourseVideos -> {
                    binding.videoCountText.text =
                        resources.getString(R.string.video_count, state.videos.size.toString())

                    val totalTime = state.videos.sumOf { it.duration }
                    val formattedDuration = DateUtil.formatDurationWithoutSeconds(totalTime)

                    binding.videoTimeCountText.text = formattedDuration
                    courseVideos = state.videos
                    courseAdapterVertical =
                        VideoListAdapter(state.videos.toMutableList()) { course ->
                            if (canUserOpenVideos) {
                                val intent = Intent(context, FullScreenPlayerActivity::class.java)
                                intent.putExtra("course", course)
                                startActivity(intent)
                            } else {
                                showAlertDialog(
                                    requireContext(), getString(R.string.purchase),
                                    getString(
                                        R.string.you_have_not_purchased
                                    )
                                ) {
                                }
                            }
                        }
                    binding.videosListView.adapter = courseAdapterVertical
                    binding.videosListView.visibility = View.VISIBLE
                }

                is DetailState.CourseLastSeenVideos -> {
                    lastSeenID = state.id
                }

                is DetailState.Loading -> {

                }
            }

        }
    }

    private fun updateWishlistButton() {
        if (binding.saveToList.tag == ADDED) {
            viewModel.removeFromWishlist(course?.id)
            binding.saveToList.setImageResource(R.drawable.ic_bookmark)
            binding.saveToList.tag = NOT_ADDED
        } else {
            viewModel.addToWishlist(course?.id)
            binding.saveToList.setImageResource(R.drawable.ic_bookmark_done)
            binding.saveToList.tag = ADDED
        }
    }

    private fun startToPlayVideos() {
        val seenVideo = if (lastSeenID != -1) {
            courseVideos?.find { it.id == lastSeenID }
        } else {
            courseVideos?.minByOrNull { it.order }
        }
        if (seenVideo != null) {
            val intent = Intent(context, FullScreenPlayerActivity::class.java)
            intent.putExtra("course", seenVideo)
            startActivity(intent)
        }
    }


    private fun setUpUI() {
        course?.let { c ->
            viewModel.getCategory(c.categoryId)
            viewModel.checkPurchaseAndWishlistStatus(c.id)
            viewModel.getCourseVideos(c.id)
            viewModel.getLastSeenVideo(c.id)
            binding.apply {
                course = c
            }
            val chipGroup = c.subTags.split(",")
            chipGroup.forEach {
                val chip = Chip(requireContext())
                chip.text = it
                chip.isCloseIconVisible = false
                chip.textSize = 12f
                chip.setPadding(3, 0, 3, 0)
                chip.chipStrokeWidth = 0.7f
                chip.setChipBackgroundColorResource(R.color.error_text_red)
                chip.chipBackgroundColor = resources.getColorStateList(R.color.error_text_red, null)
                chip.setTextColor(resources.getColor(R.color.chip_text_color, null))
                chip.isClickable = false
                binding.chipLayout.addView(chip)
            }
        }
        binding.saveToList.setOnClickListener {
            updateWishlistButton()
        }
        binding.buyCourseButton.setOnClickListener {
            showAlertDialog(
                requireContext(),
                getString(R.string.purchase),
                getString(R.string.do_you_want_to_purchase_this_course)
            ) {
                viewModel.purchase(course?.id)
                Snackbar.make(
                    requireContext(),
                    binding.root,
                    getString(R.string.successfully_purchased_course),
                    Snackbar.LENGTH_SHORT
                ).show()
                setUpUI()
            }
        }

        binding.videosListView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
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
        bottomBar?.let {
            bottomBar.visibility = View.VISIBLE

        }
    }

    private fun hideBottomBar() {
        val bottomBar = requireActivity().findViewById<View>(R.id.main_bottom_nav)
        bottomBar?.let {
            bottomBar.visibility = View.GONE
        }
    }
}