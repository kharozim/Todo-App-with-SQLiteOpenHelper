package com.kharozim.todo_app_with_sqliteopenhelper.data.remote

import com.google.gson.annotations.SerializedName
import com.kharozim.todo_app_with_sqliteopenhelper.models.TodoModel

data class InsertResponse(
    @SerializedName("data")
    val data: TodoModel
)