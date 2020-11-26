package com.kharozim.todo_app_with_sqliteopenhelper.repositories.remote

import retrofit2.Call
import retrofit2.http.*

interface gitTodoService {
    @GET("api/v1/todos")
    fun getAllTodo(): Call<TodoResponse>

    @POST("api/v1/todos")
    fun insertTodo(
        @Query("task") task: String,
        @Query("status") status: String
    ): Call<TodoResponse>

    @PUT("api/v1/todos/91")
    fun putTodo(
        @Query("task") task: String,
        @Query("status") status: String
    ): Call<TodoResponse>

    @DELETE("api/v1/todos/91")
    fun deleteTodo(@Path("id") id: Int): Call<TodoResponse>

}
