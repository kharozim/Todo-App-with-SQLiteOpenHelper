package com.kharozim.todo_app_with_sqliteopenhelper.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.kharozim.todo_app_with_sqliteopenhelper.adapters.TodoAdapter
import com.kharozim.todo_app_with_sqliteopenhelper.databinding.FragmentTodoListBinding
import com.kharozim.todo_app_with_sqliteopenhelper.models.TodoModel
import com.kharozim.todo_app_with_sqliteopenhelper.repositories.remote.ApiClient
import com.kharozim.todo_app_with_sqliteopenhelper.repositories.remote.TodoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat

class TodoListFragment : Fragment() {

    private lateinit var binding: FragmentTodoListBinding

    private val adapter by lazy { TodoAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoListBinding.inflate(inflater, container, false).apply {

            rvUsersFragment.adapter = adapter

            ApiClient.userService.getAllTodo().enqueue(object : Callback<TodoResponse> {
                override fun onResponse(
                    call: Call<TodoResponse>,
                    response: Response<TodoResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            adapter.list = it.data
                            Log.d("TAG", "onResponse: ${it.data}")
                        }
                    }
                }

                override fun onFailure(call: Call<TodoResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }

            })

            btnAdd.setOnClickListener {
                val formatter = SimpleDateFormat("MMM dd yyyy HH:mma")

                val todoModel = TodoResponse(
                    data = List(TodoModel),
                    message = tieAdd.text.toString(),
                    status = false
                )
                insertTodo(todoModel)
            }
        }
        return binding.root
    }

    private fun insertTodo(todoList: ProductModel) {
        ProductClient.service.insertProduct(productModel).enqueue(object : Callback<ProductModel> {
            override fun onResponse(call: Call<ProductModel>, response: Response<ProductModel>) {
                if (response.isSuccessful) Toast.makeText(
                    requireActivity(),
                    "Produk berhasil ditambahkan",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                onError(t)
            }
        })
    }

}