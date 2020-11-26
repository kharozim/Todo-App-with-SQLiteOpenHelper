package com.kharozim.todo_app_with_sqliteopenhelper.models

import com.google.gson.annotations.SerializedName

data class InsertModel (
    @SerializedName("task")
    val task : String,
    @SerializedName("status")
    val status : String
)