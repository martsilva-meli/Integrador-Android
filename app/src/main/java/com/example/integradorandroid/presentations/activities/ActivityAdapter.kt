package com.example.integradorandroid.presentations.activities

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.integradorandroid.databinding.FragmentActivitiesBinding
import com.example.integradorandroid.presentations.activities.content.ActivityContent.ActivityItem

/**
 * [RecyclerView.Adapter] that can display a [ActivityItem].
 * TODO: Replace the implementation with code for your data type.
 */
class ActivityAdapter(
    private val values: List<ActivityItem>,
    private val participants: Int
) : RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {

    inner class ViewHolder(binding: FragmentActivitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val contentView: TextView = binding.content
        val imageView : ImageView = binding.ivForward
        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentActivitiesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.contentView.text = item.type
        holder.imageView.setOnClickListener {
            val action = ActivitiesFragmentDirections.actionActivitiesFragmentToCategoryFragment(participants = participants, category = item.type)
            holder.contentView.findNavController().navigate(action)
        }
        holder.contentView.setOnClickListener {
            val action = ActivitiesFragmentDirections.actionActivitiesFragmentToCategoryFragment(participants = participants, category = item.type)
            holder.contentView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = values.size

}