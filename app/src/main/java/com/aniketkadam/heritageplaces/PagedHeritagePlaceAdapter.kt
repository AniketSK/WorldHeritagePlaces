package com.aniketkadam.heritageplaces

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.aniketkadam.heritageplaces.data.HeritagePlace
import com.aniketkadam.heritageplaces.databinding.LayoutHeritageItemBinding

class PagedHeritagePlaceAdapter :
    PagedListAdapter<HeritagePlace, HeritageViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<HeritagePlace>() {

            override fun areItemsTheSame(oldItem: HeritagePlace, newItem: HeritagePlace): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: HeritagePlace,
                newItem: HeritagePlace
            ): Boolean = oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeritageViewHolder =
        HeritageViewHolder(
            DataBindingUtil.inflate<LayoutHeritageItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.layout_heritage_item,
                parent,
                false
            )
        )

    // As long as placeholders are NOT enabled, getItem would always return a value
    override fun onBindViewHolder(holder: HeritageViewHolder, position: Int) =
        holder.bind(getItem(position)!!)

}