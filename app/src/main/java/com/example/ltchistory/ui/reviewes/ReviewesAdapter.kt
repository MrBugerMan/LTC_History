package com.example.ltchistory.ui.reviewes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.services.nytimes.models.Docs
import com.example.ltchistory.R
import com.example.ltchistory.databinding.ItemReviewesBinding

class ReviewesAdapter : RecyclerView.Adapter<ReviewesAdapter.ReviewesViewHolder>() {

    private val reviewesList: ArrayList<Docs> = arrayListOf()

    inner class ReviewesViewHolder(private val binding: ItemReviewesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(docs: Docs) {
            val urlPoster =
                docs.multimedia.firstOrNull { it.subtype == "verticalTwoByThree735" }?.url
            urlPoster?.let {
                Glide.with(itemView).load("https://static01.nyt.com/$it").into(binding.poster)
            }
            docs.keywords.firstOrNull { it.name == "creative_works" }?.let {
                binding.filmName.text = it.value
            }
            binding.smallReviewText.text = docs.leadParagraph
            binding.criticName.text = docs.byline?.original
            binding.textDataTime.text = docs.pubDate

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewesViewHolder {
        return ReviewesViewHolder(
            ItemReviewesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ReviewesViewHolder, position: Int) {
        reviewesList[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return reviewesList.size
    }


    fun updateList(newReviewesList: ArrayList<Docs>) {
        val diffCallback = ReviewesDiffCallback(reviewesList, newReviewesList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        reviewesList.clear()
        reviewesList.addAll(newReviewesList)
        diffResult.dispatchUpdatesTo(this)
    }

    private class ReviewesDiffCallback(
        private val oldList: List<Docs>, private val newList: List<Docs>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].Id == newList[newItemPosition].Id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }

}


