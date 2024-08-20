package com.example.ltchistory.ui.critics

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.services.nytimes.models.Byline
import com.example.ltchistory.R
import com.example.ltchistory.databinding.FragmentCriticsBinding
import com.example.ltchistory.databinding.FragmentReviewesBinding
import com.example.ltchistory.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CriticsFragment : Fragment() {

    private lateinit var binding: FragmentCriticsBinding
    private lateinit var criticsAdapter: CriticsAdapter

    private val viewModel: CriticsViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCriticsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()

        sharedViewModel.infoForCritics.observe(viewLifecycleOwner) { bylines ->
            criticsAdapter.updateList(bylines)
        }

        criticsAdapter.setOnClickListener(object : CriticsAdapter.OnClickListener {
            override fun onClick(position: Int, model: Byline) {
                Log.d("yes click", "position = $position, model = $model")
                sharedViewModel.setCriticDetails(model)
                Log.d("data", "data = ${sharedViewModel.criticDetails.value}")
                findNavController().navigate(R.id.action_criticsFragment_to_criticDetailsFragment)
            }
        })


    }

    private fun initAdapter() {
        criticsAdapter = CriticsAdapter()
        binding.recycleViewCritics.setHasFixedSize(true)
        binding.recycleViewCritics.apply {
            adapter = criticsAdapter
            layoutManager = GridLayoutManager(this.context, 2)
        }
    }


}