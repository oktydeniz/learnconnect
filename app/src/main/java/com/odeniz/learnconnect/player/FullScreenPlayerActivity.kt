package com.odeniz.learnconnect.player

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.databinding.ActivityFullScreenPlayerBinding
import com.odeniz.learnconnect.entity.Video
import com.odeniz.learnconnect.util.LinkUtils
import com.odeniz.learnconnect.util.showAlertDialog
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener

private const val ARG_PARAM1 = "course"

class FullScreenPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenPlayerBinding
    private var lastVideoTime: Float = 0f
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
        videoSetUp()
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
            showExitConfirmationDialog()
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showExitConfirmationDialog()
            }
        })
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
        Toast.makeText(this, "Video Saved", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun videoSetUp() {
        val videoId = LinkUtils.getYouTubeVideoId(video.url)
        videoId?.let {
            binding.youtubePlayerView.addYouTubePlayerListener(object :
                AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {

                    youTubePlayer.loadVideo(videoId, 0f)
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
        } ?: Toast.makeText(this, "Video Link Error", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.youtubePlayerView.release()
    }
}