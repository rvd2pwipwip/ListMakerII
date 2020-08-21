package com.raywenderlich.listmaker

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : AppCompatActivity() {
    // set a reference to the task list recycler view and make its type a RecyclerView
    private  lateinit var taskListRecyclerView: RecyclerView
    // define a property to contain the task list
    private lateinit var list: TaskList
    // declare the add_task_button
    private lateinit var addTaskButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //get the list from the MainActivity's intent
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY) as TaskList
        title = list.name

        //reference the recyclerView in activity_detail.xml
        taskListRecyclerView = findViewById(R.id.task_list_recyclerview)
        //set the layout manager to linear providing the activity as its context (this)
        taskListRecyclerView.layoutManager = LinearLayoutManager(this)
        //assign adapter to recyclerView and pass in the list
        taskListRecyclerView.adapter = TaskListAdapter(list)
        //reference the fab button in activity_detail.xml
        addTaskButton = findViewById(R.id.add_task_button)
        //set onClick listener
        addTaskButton.setOnClickListener {
            showCreateTaskDialog()
        }
    }

    override fun onBackPressed() {
        //create a bundle
        val bundle = Bundle()
        //put the parcel with the list and list key in the bundle
        bundle.putParcelable(MainActivity.INTENT_LIST_KEY, list)
        //create intent to go to main activity
        val intent = Intent()
        //put the bundle in the intent
        intent.putExtras(bundle)
        //send the result
        setResult(Activity.RESULT_OK, intent)

        super.onBackPressed()
    }

    private fun showCreateTaskDialog() {
        val taskEditText = EditText(this)
        //set input type
        taskEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
        //set dialog title, view and button
        AlertDialog.Builder(this)
            .setTitle(R.string.task_to_add)
            .setView(taskEditText)
            .setPositiveButton(R.string.add_task) { dialog, _ ->
                val task = taskEditText.text.toString()
                list.tasks.add(task)
                dialog.dismiss()
            }
            .create()
            .show()
    }
}