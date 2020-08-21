package com.raywenderlich.listmaker

import android.os.Parcel
import android.os.Parcelable

class TaskList(val name: String, val tasks: ArrayList<String> = ArrayList()): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!, //find and unwrap name of list
        parcel.createStringArrayList()!! //find and unwrap the list
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        //convert task list into parcel
        dest.writeString(name)
        dest.writeStringList(tasks)
    }

    override fun describeContents() = 0 //no file descriptors

    companion object CREATOR : Parcelable.Creator<TaskList> {
        override fun createFromParcel(source: Parcel): TaskList {
            return TaskList(source)
        }

        override fun newArray(size: Int): Array<TaskList?> {
            return arrayOfNulls(size)
        }
    }

}