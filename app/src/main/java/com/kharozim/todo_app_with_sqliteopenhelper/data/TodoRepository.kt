package com.kharozim.todo_app_with_sqliteopenhelper.data

import com.kharozim.todo_app_with_sqliteopenhelper.models.InsertModel
import com.kharozim.todo_app_with_sqliteopenhelper.models.TodoModel


interface TodoRepository {
    fun getAllTodo(): List<TodoModel>
    fun insertTodo(task: String, date: String): TodoModel
    fun deleteTodo(id: Long): Long
    fun updateTodo(todoModel: TodoModel): TodoModel


}