package com.kharozim.todo_app_with_sqliteopenhelper.repositories.remote

import com.kharozim.todo_app_with_sqliteopenhelper.models.EditModel
import com.kharozim.todo_app_with_sqliteopenhelper.models.InsertModel
import retrofit2.Call
import retrofit2.http.*

interface TodoService {
    @GET("api/v1/todos")
    fun getAllTodo(): Call<TodoResponse>

    @POST("api/v1/todos")
    fun insertTodo(
        @Body task: InsertModel,
    ): Call<TodoResponse>

    @PUT("api/v1/todos/{91}")
    fun putTodo(
        @Path("id") id: Int,
        @Body task: EditModel,
        ): Call<TodoResponse>

    @DELETE("api/v1/todos/{id}")
    fun deleteTodo(@Path("id") id: Int): Call<TodoResponse>

}
