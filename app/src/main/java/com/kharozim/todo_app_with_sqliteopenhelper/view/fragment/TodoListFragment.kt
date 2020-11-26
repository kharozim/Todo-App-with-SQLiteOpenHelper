package com.kharozim.todo_app_with_sqliteopenhelper.view.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.kharozim.todo_app_with_sqliteopenhelper.TodoContract
import com.kharozim.todo_app_with_sqliteopenhelper.data.TodoRepository
import com.kharozim.todo_app_with_sqliteopenhelper.view.TodoAdapter
import com.kharozim.todo_app_with_sqliteopenhelper.databinding.FragmentTodoListBinding
import com.kharozim.todo_app_with_sqliteopenhelper.models.InsertModel
import com.kharozim.todo_app_with_sqliteopenhelper.data.remote.ApiClient
import com.kharozim.todo_app_with_sqliteopenhelper.data.remote.TodoRemoteRepository
import com.kharozim.todo_app_with_sqliteopenhelper.data.remote.TodoResponse
import com.kharozim.todo_app_with_sqliteopenhelper.models.TodoModel
import com.ydh.todoapp.presenter.TodoPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class TodoListFragment : Fragment(), TodoContract.View {
    private lateinit var binding: FragmentTodoListBinding

    private val adapter by lazy { TodoAdapter(requireContext()) }
    private val presenter: TodoContract.Presenter by lazy { TodoPresenter(this, repository) }
    private val repository: TodoRepository by lazy {
        TodoRemoteRepository(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoListBinding.inflate(inflater, container, false)
        setView()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        presenter.getAllTodo()

    }

    private fun setView(){
        binding.run {
            rvUsersFragment.adapter = adapter
            btnAdd.setOnClickListener {
                presenter.insertTodo(tieAdd.text.toString(), date = getCurrentDate())
            }
        }

    }


    private fun getCurrentDate(): String{
        val date = LocalDateTime.now()
        return date.format(DateTimeFormatter.ofPattern("dd MM yyyy - HH:mm:ss"))
    }

    override fun onSuccessGetAllTodo(todo: List<TodoModel>) {
        val data = todo as MutableList<TodoModel>
        adapter.setData(data)    }

    override fun onSuccessInsertTodo(todoModel: TodoModel) {
        adapter.addTodo(todoModel)
        binding.tieAdd.setText("")
    }

    override fun onSuccessDeleteTodo(id: Long) {
        TODO("Not yet implemented")
    }

    override fun onSuccessUpdateTodo(todoModel: TodoModel) {
        TODO("Not yet implemented")
    }



}