package com.example.ltchistory.ui.reviewes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ltchistory.R
import com.example.ltchistory.databinding.FragmentReviewesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewesFragment : Fragment() {

    private lateinit var binding: FragmentReviewesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReviewesBinding.inflate(layoutInflater)
        return binding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()

    }

    private fun initUi() {
        TODO()
    }*/

}