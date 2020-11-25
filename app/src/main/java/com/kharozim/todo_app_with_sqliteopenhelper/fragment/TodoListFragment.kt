package com.kharozim.todo_app_with_sqliteopenhelper.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.kharozim.todo_app_with_sqliteopenhelper.R
import com.kharozim.todo_app_with_sqliteopenhelper.databinding.FragmentTodoListBinding
import com.kharozim.todo_app_with_sqliteopenhelper.repositories.remote.ApiClient
import com.kharozim.todo_app_with_sqliteopenhelper.repositories.remote.TodoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoListFragment : Fragment() {

private lateinit var binding : FragmentTodoListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoListBinding.inflate(inflater, container, false).apply {

            ApiClient.userService.getAllTodo().enqueue(object : Callback<TodoResponse> {
                override fun onResponse(
                    call: Call<TodoResponse>,
                    response: Response<TodoResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            Log.d("TAG", "onResponse: ${it.data}")
                        }
                    }
                }
                override fun onFailure(call: Call<TodoResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }

            })
        }
        return binding.root
    }

}