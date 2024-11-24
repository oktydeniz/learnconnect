package com.odeniz.learnconnect.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.odeniz.learnconnect.databinding.VideoListItemBinding
import com.odeniz.learnconnect.entity.Video

class VideoListAdapter(
    private val list: MutableList<Video>,
    private val onItemClicked: (Video) -> Unit
) : RecyclerView.Adapter<VideoListAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(private val binding: VideoListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(video: Video) {
            binding.item = video
            itemView.setOnClickListener { onItemClicked(video) }
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding =
            VideoListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

}