package com.aniketkadam.heritageplaces

import androidx.recyclerview.widget.RecyclerView
import com.aniketkadam.heritageplaces.data.HeritagePlace
import com.aniketkadam.heritageplaces.databinding.LayoutHeritageItemBinding

class HeritageViewHolder(private val binding: LayoutHeritageItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(heritage: HeritagePlace) {
        binding.apply {
            place = heritage
            executePendingBindings()
        }
    }
}