package com.example.shemajamebeli_8.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shemajamebeli_8.R
import com.example.shemajamebeli_8.databinding.PlaceCardBinding
import com.example.shemajamebeli_8.presentation.model.PlaceUI

class PlaceCardAdapter : ListAdapter<PlaceUI, PlaceCardAdapter.PlaceCardViewHolder>(DiffUtil) {

    inner class PlaceCardViewHolder(private val binding: PlaceCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = currentList[adapterPosition]
            with(binding) {
                price.text = item.price
                tvTitle.text = item.title
                tvCount.text = item.reactionCount.toString()
                Glide.with(root)
                    .load(item.cover)
                    .into(ivImage)

                item.rate?.let { rate ->
                    val stars = listOf(star1, star2, star3, star4, star5)
                    for (i in 0 until minOf(rate, stars.size)) {
                        stars[i].setBackgroundResource(R.drawable.ic_star_on)
                    }
                }
            }
        }
    }

    companion object {
        private val DiffUtil = object : DiffUtil.ItemCallback<PlaceUI>() {
            override fun areItemsTheSame(oldItem: PlaceUI, newItem: PlaceUI): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PlaceUI, newItem: PlaceUI): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceCardViewHolder {
        return PlaceCardViewHolder(
            PlaceCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaceCardViewHolder, position: Int) {
        holder.bind()
    }

}