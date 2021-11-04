package com.example.integradorandroid.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.navigation.fragment.findNavController
import com.example.integradorandroid.R
import com.example.integradorandroid.databinding.FragmentTermsBinding
import com.example.integradorandroid.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTerms.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToTermsFragment()
            findNavController().navigate(action)
        }
        binding.btnStart.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToActivitiesFragment(participants = binding.etParticipants.text.toString().toInt())
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}