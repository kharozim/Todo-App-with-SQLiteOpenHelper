package com.kharozim.todo_app_with_sqliteopenhelper.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kharozim.todo_app_with_sqliteopenhelper.R
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

        fun binData(todoModel: TodoModel) {
            binding.run {
                tvNote.text = todoModel.task
                tvDate.text = todoModel.date
                ivStatus.setImageResource(if (todoModel.status == false) R.drawable.ic_note else R.drawable.ic_done)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTodoListBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(list[position])
    }

    override fun getItemCount(): Int = list.size
}