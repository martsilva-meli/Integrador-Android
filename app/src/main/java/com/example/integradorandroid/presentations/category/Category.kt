package com.example.integradorandroid.presentations.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.integradorandroid.R
import com.example.integradorandroid.databinding.ActivityCategoryBinding

class Category : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding
    // instancia del View Model
    private val viewModel : CategoryViewModel by viewModels(
        factoryProducer = {
            CategoryViewModelFactory()
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


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