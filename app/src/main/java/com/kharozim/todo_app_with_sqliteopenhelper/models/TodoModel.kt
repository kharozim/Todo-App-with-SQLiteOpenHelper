package com.kharozim.todo_app_with_sqliteopenhelper.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TodoModel(val id: Long, val task: String, val Status: Boolean) : Parcelable
