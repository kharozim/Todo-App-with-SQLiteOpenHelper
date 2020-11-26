package com.kharozim.todo_app_with_sqliteopenhelper.data.remote

import android.content.Context
import android.os.StrictMode
import com.kharozim.todo_app_with_sqliteopenhelper.data.TodoRepository
import com.kharozim.todo_app_with_sqliteopenhelper.models.InsertModel
import com.kharozim.todo_app_with_sqliteopenhelper.models.TodoModel



class TodoRemoteRepository(context: Context): TodoRepository {


    override fun getAllTodo(): List<TodoModel> {
        val policy = StrictMode.ThreadPolicy.Builder()
            .permitAll().build()
        StrictMode.setThreadPolicy(policy)
        return ApiClient.userService.getAllTodo().execute().body()?.data as MutableList<TodoModel>
    }

    override fun insertTodo(task: String, date: String): TodoModel {
        val policy = StrictMode.ThreadPolicy.Builder()
                .permitAll().build()
        StrictMode.setThreadPolicy(policy)
        return ApiClient.userService.insertTodo(InsertModel(task,status = "false")).execute().body()!!.data

    }

    override fun deleteTodo(id: Long): Long {
        TODO("Not yet implemented")
    }

    override fun updateTodo(todoModel: TodoModel): TodoModel {
        TODO("Not yet implemented")
    }

}