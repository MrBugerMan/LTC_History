package com.example.ltchistory.ui.reviewes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ltchistory.databinding.FragmentReviewesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewesFragment : Fragment() {

    private lateinit var binding: FragmentReviewesBinding
    private lateinit var reviewesAdapter: ReviewesAdapter

    private val viewModel: ReviewesViewModel by viewModels()


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

        /*binding.recycleViewReviewes.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) {
                    viewModel.loadNextPage()
                } else if (!recyclerView.canScrollVertically(-1)) {
                    viewModel.loadPreviousPage()
                }
            }
        })*/


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