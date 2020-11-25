package com.kharozim.todo_app_with_sqliteopenhelper.adapters

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kharozim.todo_app_with_sqliteopenhelper.databinding.ItemTodoListBinding
import com.kharozim.todo_app_with_sqliteopenhelper.models.TodoModel

class TodoAdapter(private val context: Context) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    var list = listOf<TodoModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(private val binding: ItemTodoListBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun binData(todoModel: TodoModel){
                binding.run {
//                    tvNote.text = todoModel.task
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.size
}