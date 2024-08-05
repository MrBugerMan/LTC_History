package com.example.ltchistory.ui.reviewes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ltchistory.databinding.FragmentReviewesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewesFragment : Fragment() {

    private lateinit var binding: FragmentReviewesBinding
    private lateinit var reviewesAdapter: ReviewesAdapter

    private val viewModel: ReviewesViewModel by viewModels<ReviewesViewModel>() // viewModels()
    /* // без hilt
    private val viewModel: ReviewesViewModel by lazy {
        ReviewesViewModel()
    }*/


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReviewesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()

        viewModel.allReviewes.observe(viewLifecycleOwner) {
            it.response?.let { it1 -> reviewesAdapter.updateList(it1.docs) }
        }

    }

    private fun initAdapter() {
        reviewesAdapter = ReviewesAdapter()
        binding.recycleViewReviewes.setHasFixedSize(true)
        binding.recycleViewReviewes.apply {
            adapter = reviewesAdapter
            layoutManager = LinearLayoutManager(this.context)
        }
    }

}