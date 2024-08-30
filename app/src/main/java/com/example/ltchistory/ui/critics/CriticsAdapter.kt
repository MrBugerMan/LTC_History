package com.example.ltchistory.ui.critics

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.data.network.nytimes.models.Byline
import com.example.domain.models.BylineDomain
import com.example.ltchistory.databinding.ItemCriticBinding

class CriticsAdapter : RecyclerView.Adapter<CriticsAdapter.CriticsViewHolder>() {

    private val criticsList: ArrayList<BylineDomain> = arrayListOf()
    private var onClickListener: OnClickListener? = null

    inner class CriticsViewHolder(private val binding: ItemCriticBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(byline: BylineDomain) {
            binding.nameCritic.text = "${byline.person[0].firstname} ${byline.person[0].lastname}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriticsViewHolder {
        return CriticsViewHolder(
            ItemCriticBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CriticsViewHolder, position: Int) {
        criticsList[position].let { holder.bind(it) }

        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position, criticsList[position])
        }
    }

    override fun getItemCount(): Int {
        return criticsList.size
    }

    interface OnClickListener {
        fun onClick(position: Int, model: BylineDomain)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }


    fun updateList(newList: ArrayList<BylineDomain>) {
        val diffCallback = CriticsDiffCallback(criticsList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        criticsList.clear()
        criticsList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    private class CriticsDiffCallback(
        private val oldList: List<BylineDomain>, private val newList: List<BylineDomain>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].person[0].firstname == newList[newItemPosition].person[0].firstname && oldList[oldItemPosition].person[0].lastname == newList[newItemPosition].person[0].lastname
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}