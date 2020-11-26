package com.kharozim.todo_app_with_sqliteopenhelper.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kharozim.todo_app_with_sqliteopenhelper.databinding.FragmentTodoBinding

class TodoFragment : Fragment() {

private lateinit var binding : FragmentTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoBinding.inflate(inflater, container, false).apply {


        }

        return binding.root
    }

}