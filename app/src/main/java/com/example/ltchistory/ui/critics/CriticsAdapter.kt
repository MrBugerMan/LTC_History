package com.example.ltchistory.ui.critics

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.domain.models.Byline
import com.example.domain.domain.models.Docs
import com.example.ltchistory.databinding.FragmentCriticsBinding
import com.example.ltchistory.databinding.FragmentReviewesBinding
import com.example.ltchistory.databinding.ItemCriticBinding

class CriticsAdapter : RecyclerView.Adapter<CriticsAdapter.CriticsViewHolder>() {

    private var criticsList: ArrayList<Byline> = arrayListOf()
    private var onClickListener: OnClickListener? = null

    inner class CriticsViewHolder(private val binding: ItemCriticBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(byline: Byline) {
            binding.nameCritic.text = "${byline.person[0].firstname} ${byline.person[0].lastname}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriticsViewHolder {
        return CriticsViewHolder(
            ItemCriticBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
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
        fun onClick(position: Int, model: Byline)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: ArrayList<Byline>) {
        this.criticsList = newList
        notifyDataSetChanged()
    }
}