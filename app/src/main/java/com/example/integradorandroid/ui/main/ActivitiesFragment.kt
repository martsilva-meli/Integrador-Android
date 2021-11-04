package com.example.integradorandroid.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.integradorandroid.R
import com.example.integradorandroid.ui.main.placeholder.ActivityContent

/**
 * A fragment representing a list of Items.
 */
class ActivitiesFragment : Fragment() {


    private var participantsCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            participantsCount = it.getInt(PARTICIPANTS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_activities_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = ActivityAdapter(ActivityContent.ITEMS,participantsCount)
            }
        }
        return view
    }

    companion object {

        const val PARTICIPANTS = "participants"

    }
}