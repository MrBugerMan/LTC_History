package com.example.ltchistory.ui.critics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ltchistory.R
import com.example.ltchistory.databinding.FragmentCriticsBinding
import com.example.ltchistory.databinding.FragmentReviewesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CriticsFragment : Fragment() {

    private lateinit var binding: FragmentCriticsBinding
    private lateinit var criticsAdapter: CriticsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCriticsBinding.inflate(layoutInflater)
        return binding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()

    }

    private fun initAdapter() {
        criticsAdapter = CriticsAdapter()
        binding.recycleViewCritics.setHasFixedSize(true)
        binding.recycleViewCritics.apply {
            adapter = criticsAdapter
            layoutManager = GridLayoutManager(this.context, 2)
        }
    }*/


}