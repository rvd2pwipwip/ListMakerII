package com.raywenderlich.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//extend RecyclerView.Adapter and tell it to use the TodoListViewHolder object type
class TodoListAdapter: RecyclerView.Adapter<TodoListViewHolder>() {

    // fake data
    private var todoLists = mutableListOf("Android Development", "House Work", "Errands", "Shopping")

    //create a function that will add an item to the list and notify the recycler view about it
    fun addNewItem(listName: String = "") {
        // check to see if listName is empty to add a default todo or add the user entered todo name
        if (listName.isEmpty()) {
            todoLists.add("Todo List ${todoLists.size + 1}")
        } else {
            todoLists.add(listName)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        //inflate the layout of the view holder and pass it to its constructor
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_list_view_holder, parent, false)
        return TodoListViewHolder(view)
    }

    override fun getItemCount() = todoLists.size

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        //bind data to ViewHolder's layout ui components
        holder.listPositionTextView.text = (position + 1).toString()
        holder.listTitleTextView.text = todoLists[position]
    }
}