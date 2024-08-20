package com.example.ltchistory.ui.criticdetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.services.nytimes.models.Docs
import com.example.ltchistory.databinding.ItemReviewesBinding

class CriticDetailsAdapter: RecyclerView.Adapter<CriticDetailsAdapter.CriticDetailsViewHolder>() {

    private var criticDetailsList: ArrayList<Docs> = arrayListOf()

    inner class CriticDetailsViewHolder( private val binding: ItemReviewesBinding) : RecyclerView.ViewHolder(binding.root) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriticDetailsAdapter.CriticDetailsViewHolder {
        return CriticDetailsViewHolder(
            ItemReviewesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CriticDetailsAdapter.CriticDetailsViewHolder, position: Int) {
        criticDetailsList[position].let { holder.bind(it) }

    }

    override fun getItemCount(): Int {
        return criticDetailsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: ArrayList<Docs>) {
        this.criticDetailsList = newList
        notifyDataSetChanged()
    }

}