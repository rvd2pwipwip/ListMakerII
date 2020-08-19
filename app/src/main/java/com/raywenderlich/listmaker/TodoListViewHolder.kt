package com.raywenderlich.listmaker

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// primary constructor must receive a view (itemView) from Adapter's onCreateViewHolder
// and pass it to super constructor
class TodoListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    // tell viewHolder about the text views in todo_list_view_holder layout
    var listPositionTextView: TextView = itemView.findViewById(R.id.itemNumber)
    var listTitleTextView: TextView = itemView.findViewById(R.id.itemString)
}