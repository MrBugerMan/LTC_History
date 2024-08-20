package com.example.ltchistory.ui.reviewes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.services.nytimes.models.Docs
import com.example.ltchistory.R
import com.example.ltchistory.databinding.ItemReviewesBinding

class ReviewesAdapter : RecyclerView.Adapter<ReviewesAdapter.ReviewesViewHolder>() {

    private var reviewesList: ArrayList<Docs> = arrayListOf()

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
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReviewesViewHolder, position: Int) {
        reviewesList[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return reviewesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(reviewesList: ArrayList<Docs>) {
        this.reviewesList = reviewesList
        notifyDataSetChanged()
    }
}


// попытка пагинации
/*class ReviewesAdapter: RecyclerView.Adapter<ReviewesAdapter.ReviewesViewHolder>() {

    private var reviewesList: ArrayList<Docs> = arrayListOf()

    inner class ReviewesViewHolder(private val binding: ItemReviewesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(docs: Docs) {
            val urlPoster = docs.multimedia.firstOrNull { it.subtype == "verticalTwoByThree735" }?.url
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
                LayoutInflater.from(parent.context),
                parent,
                false
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
        val oldSize = reviewesList.size
        reviewesList.clear()
        reviewesList.addAll(newReviewesList)
        notifyItemRangeChanged(oldSize, newReviewesList.size)
    }
}*/
