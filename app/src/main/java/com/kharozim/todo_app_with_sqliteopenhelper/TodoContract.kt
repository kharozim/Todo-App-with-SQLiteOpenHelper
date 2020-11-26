package com.kharozim.todo_app_with_sqliteopenhelper

import com.kharozim.todo_app_with_sqliteopenhelper.models.TodoModel

interface TodoContract {

    interface View {
        fun onSuccessGetAllTodo(todo: List<TodoModel>)
        fun onSuccessInsertTodo(todoModel: TodoModel)
        fun onSuccessDeleteTodo(id: Long)
        fun onSuccessUpdateTodo(todoModel: TodoModel)
    }

    interface Presenter {
        fun getAllTodo()
        fun insertTodo(task: String, date: String)
        fun deleteTodo(id: Long)
        fun updateTodo(todoModel: TodoModel)

    }
}