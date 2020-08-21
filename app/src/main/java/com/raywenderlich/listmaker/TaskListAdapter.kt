package com.raywenderlich.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//default constructor accepts a task list
class TaskListAdapter(private var list: TaskList): RecyclerView.Adapter<TaskListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        //create a view that inflates the task_view_holder layout and return it
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_view_holder, parent, false)
        return TaskListViewHolder(view)
    }

    override fun getItemCount() = list.tasks.size

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        //set text to the corresponding task list item
        holder.taskTextView.text = list.tasks[position]
    }
}