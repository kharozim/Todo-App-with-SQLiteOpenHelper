package com.kharozim.todo_app_with_sqliteopenhelper.repositories.remote

import retrofit2.Call
import retrofit2.http.GET

interface TodoService {
    @GET("api/v1/todos")
    fun getAllTodo() : Call<TodoResponse>
}
