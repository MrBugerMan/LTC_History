package com.example.ltchistory.ui.criticdetails

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ltchistory.R
import com.example.ltchistory.databinding.FragmentCriticDetailsBinding
import com.example.ltchistory.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CriticDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCriticDetailsBinding
    private lateinit var criticDetailsAdapter: CriticDetailsAdapter

    private val viewModel: CriticDetailsViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCriticDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.criticDetails.observe(viewLifecycleOwner, Observer {
            it.response?.let { it1 -> criticDetailsAdapter.updateList(it1.docs) }
        })

        initViews()
        initAdapter()
    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {
        sharedViewModel.criticDetails.observe(viewLifecycleOwner) {
            binding.nameCritic.text = "${it.person[0].firstname} ${it.person[0].lastname}"
        }
    }

    private fun initAdapter() {
        criticDetailsAdapter = CriticDetailsAdapter()
        binding.recycleViewCriticReviewes.setHasFixedSize(true)
        binding.recycleViewCriticReviewes.apply {
            adapter = criticDetailsAdapter
            layoutManager = LinearLayoutManager(this.context)
        }
    }


}