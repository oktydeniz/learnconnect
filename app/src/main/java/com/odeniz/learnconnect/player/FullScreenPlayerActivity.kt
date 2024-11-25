package com.odeniz.learnconnect.player

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.databinding.ActivityFullScreenPlayerBinding
import com.odeniz.learnconnect.entity.Video
import com.odeniz.learnconnect.entity.VideoProgress
import com.odeniz.learnconnect.util.LinkUtils
import com.odeniz.learnconnect.util.showAlertDialog
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "course"

@AndroidEntryPoint
class FullScreenPlayerActivity : AppCompatActivity() {

    private val viewModel: FullScreenViewModel by viewModels()
    private lateinit var binding: ActivityFullScreenPlayerBinding
    private var lastVideoTime: Float = 0f
    private var videoProgress: VideoProgress? = null
    private lateinit var video: Video

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenPlayerBinding.inflate(layoutInflater)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        setupUI()
    }

    private fun setupUI() {
        lifecycle.addObserver(binding.youtubePlayerView)
        video = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(ARG_PARAM1, Video::class.java)!!
        } else {
            intent.getSerializableExtra(ARG_PARAM1) as Video
        }
        binding.toolbarTitle.text = video.title
        binding.backActionPlayer.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showExitConfirmationDialog()
            }
        })
        observeState()
    }

    private fun observeState() {
        viewModel.getProgress(video.id)
        viewModel.state.observe(this) { state ->
            when (state) {
                is FullScreenState.Loading -> {
                }

                is FullScreenState.FoundProgress -> {
                    videoProgress = state.videoProgress
                    lastVideoTime = state.videoProgress.progress
                    videoSetUp()
                }

                is FullScreenState.Error -> {
                    lastVideoTime = 0f
                    videoSetUp()
                }

                else -> {
                    lastVideoTime = 0f
                    videoSetUp()
                }
            }
        }
    }

    private fun showExitConfirmationDialog() {
        showAlertDialog(
            this, getString(R.string.exiting),
            getString(R.string.are_you_sure_you_want_to_exit)
        ) {
            saveProgress()
        }
    }

    private fun saveProgress() {
        if (lastVideoTime != 0f) {
            viewModel.saveProgress(lastVideoTime, video.id, video.courseId)
            finish()
        }
    }

    private fun videoSetUp() {
        val videoId = LinkUtils.getYouTubeVideoId(video.url)
        videoId?.let {
            binding.youtubePlayerView.addYouTubePlayerListener(object :
                AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {

                    youTubePlayer.loadVideo(videoId, lastVideoTime)
                    youTubePlayer.addListener(object : YouTubePlayerListener {
                        override fun onApiChange(youTubePlayer: YouTubePlayer) {
                        }

                        override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {
                            lastVideoTime = second
                        }

                        override fun onError(
                            youTubePlayer: YouTubePlayer,
                            error: PlayerConstants.PlayerError
                        ) {
                        }

                        override fun onPlaybackQualityChange(
                            youTubePlayer: YouTubePlayer,
                            playbackQuality: PlayerConstants.PlaybackQuality
                        ) {
                        }

                        override fun onPlaybackRateChange(
                            youTubePlayer: YouTubePlayer,
                            playbackRate: PlayerConstants.PlaybackRate
                        ) {
                        }

                        override fun onReady(youTubePlayer: YouTubePlayer) {
                        }

                        override fun onStateChange(
                            youTubePlayer: YouTubePlayer,
                            state: PlayerConstants.PlayerState
                        ) {
                        }

                        override fun onVideoDuration(
                            youTubePlayer: YouTubePlayer,
                            duration: Float
                        ) {
                        }

                        override fun onVideoId(youTubePlayer: YouTubePlayer, videoId: String) {
                        }

                        override fun onVideoLoadedFraction(
                            youTubePlayer: YouTubePlayer,
                            loadedFraction: Float
                        ) {
                        }
                    })
                }
            })
        } ?: showAlert()
    }

    private fun showAlert() {
        showAlertDialog(
            this, getString(R.string.error),
            getString(R.string.we_can_not_play_video)
        ) {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.youtubePlayerView.release()
    }
}