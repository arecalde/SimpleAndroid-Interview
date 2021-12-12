package com.carerevolutions.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.carerevolutions.myapplication.databinding.ListFragmentBinding

class ListFragment : Fragment() {
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ListFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel

        viewModel.states.observe(viewLifecycleOwner) {
            binding.recyclerView.adapter = ListAdapter(it, viewLifecycleOwner)
        }

        return binding.root
    }
}