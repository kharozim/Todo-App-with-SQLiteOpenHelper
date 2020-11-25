package com.kharozim.todo_app_with_sqliteopenhelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.kharozim.todo_app_with_sqliteopenhelper.adapters.ViewPagerAdapter
import com.kharozim.todo_app_with_sqliteopenhelper.databinding.ActivityMainBinding
import com.kharozim.todo_app_with_sqliteopenhelper.databinding.FragmentTodoBinding
import com.kharozim.todo_app_with_sqliteopenhelper.fragment.FavoritesFragment
import com.kharozim.todo_app_with_sqliteopenhelper.fragment.ProfileFragment
import com.kharozim.todo_app_with_sqliteopenhelper.fragment.TodoListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fragments by lazy {
        listOf(TodoListFragment(), FavoritesFragment(), ProfileFragment())
    }
    private val viewPagerAdapter by lazy {
        ViewPagerAdapter(
            fragments,
            supportFragmentManager,
            lifecycle
        )
    }
    private lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.run {

            vpMain.adapter = viewPagerAdapter
            setupOnSwipeViewPager()
            bnv_main.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_list -> {
                        vpMain.currentItem = 0
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.menu_fav -> {
                        vpMain.currentItem = 1
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.menu_profile -> {
                        vpMain.currentItem = 2
                        return@setOnNavigationItemSelectedListener true
                    }
                    else -> false
                }
            }

        }
    }

    // setup on swipe view pager
    private fun setupOnSwipeViewPager() {
        binding.run {
            vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    bnvMain.menu.getItem(0).isChecked = false
                    bnvMain.menu.getItem(position).isChecked = true
                    menuItem = bnvMain.menu.getItem(position)
                }
            })
        }

    }

}