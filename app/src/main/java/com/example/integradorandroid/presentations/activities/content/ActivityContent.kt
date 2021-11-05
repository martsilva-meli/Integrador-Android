package com.example.integradorandroid.presentations.activities.content

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object ActivityContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<ActivityItem> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, ActivityItem> = HashMap()

    private val COUNT = 9

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createActivityItem(i-1))
        }
    }

    private fun addItem(item: ActivityItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createActivityItem(position: Int): ActivityItem {
        return ActivityItem(position.toString(), ActivityTitle.values()[position].type)
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class ActivityItem(val id: String, val type: String) {
        override fun toString(): String = type
    }

    enum class ActivityTitle(val type: String){
        EDUCATION("Education"),
        RECREATIONAL("Recreational"),
        SOCIAL("Social"),
        DIY("Diy"),
        CHARITY("Charity"),
        COOKING("Cooking"),
        RELAXATION("Relaxation"),
        MUSIC("Music"),
        BUSYWORK("Busywork")
    }
}