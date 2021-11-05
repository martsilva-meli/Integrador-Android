package com.example.integradorandroid.presentations.activities

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.integradorandroid.R
import com.example.integradorandroid.presentations.activities.content.ActivityContent

/**
 * A fragment representing a list of Items.
 */
class ActivitiesFragment : Fragment() {


    private var participantsCount = 1

    companion object {
        const val PARTICIPANTS = "participants"
        const val CATEGORY = "category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        arguments?.let {
            participantsCount = it.getInt(PARTICIPANTS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_activities_list, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Activities"
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = ActivityAdapter(ActivityContent.ITEMS,participantsCount)
            }
        }
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_random ->{
                val action = ActivitiesFragmentDirections.actionActivitiesFragmentToCategoryFragment(participantsCount,null)
                findNavController().navigate(action)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}