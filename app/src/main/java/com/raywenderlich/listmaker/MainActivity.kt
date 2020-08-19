package com.raywenderlich.listmaker

import android.os.Bundle
import android.text.InputType
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var todoListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //reference the lists_recyclerview from content_main.xml
        todoListRecyclerView = findViewById(R.id.lists_recyclerview)
        //tell recyclerView which layout to use for its items
        todoListRecyclerView.layoutManager = LinearLayoutManager(this)
        //assign custom adapter to recyclerView
        todoListRecyclerView.adapter = TodoListAdapter()

        fab.setOnClickListener { view ->
            // get the recycler view adapter from the RecyclerView (todoListRecyclerView)
            // and cast as own TodoListAdapter
            val adapter = todoListRecyclerView.adapter as TodoListAdapter
            adapter.addNewItem()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}