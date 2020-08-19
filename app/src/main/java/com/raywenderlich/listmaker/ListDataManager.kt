package com.raywenderlich.listmaker

import android.content.Context
import androidx.preference.PreferenceManager // Manually import androidx version of PreferenceManager…

//Create a new ListDataManager class to save and read the task lists to disk
//Add a context to the constructor
class ListDataManager(private val context: Context) {
    //saveList takes in a task list and saves it to disk through shared prefs
    fun saveList(list: TaskList) {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context).edit()
        sharedPrefs.putStringSet(list.name, list.tasks.toHashSet()) // convert from list to set
        sharedPrefs.apply()
    }
    //read data
    fun readLists(): ArrayList<TaskList> {
        //access android preference manager
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        //access shared preferences content (map of key/value pairs)
        val contents = sharedPrefs.all
        //create a list to hold task lists
        val taskLists = ArrayList<TaskList>()
        //loop through keys
        for (taskList in contents) {
            //get saved hash set and convert it to an array list
            val taskItems = ArrayList(taskList.value as HashSet<String>)
            //create a task list from converted hash set
            val list = TaskList(taskList.key, taskItems)
            //add the list to the array
            taskLists.add(list)
        }
        return taskLists
    }
}