package com.example.integradorandroid.presentations.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.integradorandroid.databinding.FragmentCategoryBinding
import com.example.integradorandroid.presentations.activities.ActivitiesFragment

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private var participantsCount = 0
    private var category : String? = null

    // instancia del View Model
    private val viewModel : CategoryViewModel by viewModels(
        factoryProducer = {
            CategoryViewModelFactory()
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            participantsCount = it.getInt(ActivitiesFragment.PARTICIPANTS)
            category = it.getString(ActivitiesFragment.CATEGORY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        setObserver()
    }

    private fun initView() {
        TODO("Not yet implemented")
    }

    private fun setObserver() {
        TODO("Not yet implemented")
    }
}