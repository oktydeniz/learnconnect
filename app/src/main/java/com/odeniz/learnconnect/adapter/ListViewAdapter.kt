package com.odeniz.learnconnect.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.odeniz.learnconnect.databinding.ListItemBinding
import com.odeniz.learnconnect.entity.Category

class ListViewAdapter(
    private val items: List<Category>,
    private val onItemClicked: (Category) -> Unit
) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ListItemBinding = if (convertView == null) {
            ListItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        } else {
            convertView.tag as ListItemBinding
        }

        val item = items[position]
        binding.itemText.text = item.categoryName
        binding.itemLayout.setOnClickListener {
            onItemClicked(item)
        }

        binding.root.tag = binding
        return binding.root
    }
}