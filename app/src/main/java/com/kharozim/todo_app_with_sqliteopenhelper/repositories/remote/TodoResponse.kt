package com.kharozim.todo_app_with_sqliteopenhelper.repositories.remote

import com.google.gson.annotations.SerializedName
import com.kharozim.todo_app_with_sqliteopenhelper.models.TodoModel

data class TodoResponse(

	@field:SerializedName("data")
	val data: List<TodoModel>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Boolean
)