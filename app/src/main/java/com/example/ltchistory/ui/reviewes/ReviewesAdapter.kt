package com.example.ltchistory.ui.reviewes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.domain.models.Docs
import com.example.ltchistory.R
import com.example.ltchistory.databinding.ItemReviewesBinding

class ReviewesAdapter:RecyclerView.Adapter<ReviewesAdapter.ReviewesViewHolder>() {

    private var reviewesList: ArrayList<Docs> = arrayListOf()

    inner class ReviewesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(docs: Docs) {
            val text: TextView = itemView.findViewById(R.id.text)
            text.text = docs.byline?.person?.get(0)?.firstname ?: "None"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewesViewHolder {
        return ReviewesViewHolder(
            ItemReviewesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
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