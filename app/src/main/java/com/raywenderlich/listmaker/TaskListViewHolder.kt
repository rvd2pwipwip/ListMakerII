package com.raywenderlich.listmaker

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //get a reference to the task textView
    var taskTextView: TextView = itemView.findViewById(R.id.textView_task)
}
