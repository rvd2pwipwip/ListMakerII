package com.raywenderlich.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//extend RecyclerView.Adapter and tell it to use the TodoListViewHolder object type
//after ListDataManager is used, add a constructor to the adapter that will receive the lists as an array of TaskList objects
class TodoListAdapter(private val lists: ArrayList<TaskList>): RecyclerView.Adapter<TodoListViewHolder>() {

    fun addList(list: TaskList) {
        lists.add(list)
        //tell recycler view about new list insertion
        notifyItemInserted(lists.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        //inflate the layout of the view holder and pass it to its constructor
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_list_view_holder, parent, false)
        return TodoListViewHolder(view)
    }

    override fun getItemCount() = lists.size

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        //bind data to ViewHolder's layout ui components
        holder.listPositionTextView.text = (position + 1).toString()
//        holder.listTitleTextView.text = todoLists[position]
        holder.listTitleTextView.text = lists[position].name //data from dataListManager
    }
}