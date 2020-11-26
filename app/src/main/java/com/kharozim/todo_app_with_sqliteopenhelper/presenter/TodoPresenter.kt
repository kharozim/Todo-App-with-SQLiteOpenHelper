package com.ydh.todoapp.presenter

import com.kharozim.todo_app_with_sqliteopenhelper.TodoContract
import com.kharozim.todo_app_with_sqliteopenhelper.data.TodoRepository
import com.kharozim.todo_app_with_sqliteopenhelper.models.TodoModel


class TodoPresenter(private val view: TodoContract.View, private val repository: TodoRepository) :
    TodoContract.Presenter {


    override fun getAllTodo() {
            val todoList by lazy { repository.getAllTodo() }
        println(todoList)
        view.onSuccessGetAllTodo(todoList)
    }

    override fun updateTodo(todoModel: TodoModel) {
        val todo by lazy { repository.updateTodo(todoModel) }
        view.onSuccessUpdateTodo(todo)
    }

    override fun insertTodo(task: String, date: String) {
        val todo by lazy { repository.insertTodo(task, date) }
        view.onSuccessInsertTodo(todo)
    }

    override fun deleteTodo(id: Long) {
        val todoId by lazy { repository.deleteTodo(id) }
        view.onSuccessDeleteTodo(todoId)
    }
}