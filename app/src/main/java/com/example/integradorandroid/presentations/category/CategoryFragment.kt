package com.example.integradorandroid.presentations.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.integradorandroid.R
import com.example.integradorandroid.data.response.TypeStatus
import com.example.integradorandroid.databinding.FragmentCategoryBinding
import com.example.integradorandroid.presentations.activities.ActivitiesFragment

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private var participantsCount = 0
    private var category: String? = null

    // instancia del View Model
    private val viewModel: CategoryViewModel by viewModels(
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
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        setObserver()
        initListener()
        viewModel.getActivities(category?.lowercase())
    }

    private fun initView() {
        (activity as AppCompatActivity).supportActionBar?.title = category?.let {
            it
        } ?: run {
            "Random"
        }
    }

    private fun initListener() {
        binding.btnTryAnother.setOnClickListener { viewModel.getActivities(category?.lowercase()) }
    }

    private fun setObserver() {
        // funcion para observar un cambio de estado en la variable activities
        viewModel.activities.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                TypeStatus.LOADING -> {
                    showAndHideElements(false)
                }
                TypeStatus.SUCCESS -> {
                    showAndHideElements(true)
                    it.response?.let {
                        // with es para acceder a todos los elementos del binding
                        with(binding) {
                            titleCategory.text = it.activities
                            txtNumberparticipants.text = participantsCount.toString()
                            txtPrice.text = priceFormat(it.price)
                            category?.let {
                                relativeRelaxation.visibility = View.GONE
                            } ?: run {
                                relativeRelaxation.visibility = View.VISIBLE
                                txtRelaxation.text = it.type
                            }
                        }
                    }
                }
                TypeStatus.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(context, getString(R.string.label_error_api), Toast.LENGTH_SHORT)
                        .show()
                    val action =
                        CategoryFragmentDirections.actionCategoryFragmentToActivitiesFragment(
                            participants = participantsCount
                        )
                    findNavController().navigate(action)
                }
            }
        })
    }

    private fun priceFormat(price: Double): String {
        return when (price) {
            0.0 -> "Free"
            in 0.1..0.3 -> "Low"
            in 0.4..0.6 -> "Medium"
            else -> "High"
        }
    }

    private fun showAndHideElements(active: Boolean) {
        with(binding) {
            titleCategory.isVisible = active
            relativeParticipants.isVisible = active
            relativePrice.isVisible = active
            relativeRelaxation.isVisible = active
            progressBar.isVisible = !active
        }
    }
}