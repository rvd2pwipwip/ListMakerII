package com.raywenderlich.listmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {
    // define a property to contain the task list
    private lateinit var list: TaskList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //get the list from the MainActivity's intent
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY) as TaskList
        title = list.name
    }
}