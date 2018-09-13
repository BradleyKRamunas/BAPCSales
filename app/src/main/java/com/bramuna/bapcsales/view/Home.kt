package com.bramuna.bapcsales.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bramuna.bapcsales.R
import com.bramuna.bapcsales.model.api.PostData
import com.bramuna.bapcsales.view.adapters.PostAdapter
import com.bramuna.bapcsales.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    private var sales: MutableList<PostData> = mutableListOf()
    private lateinit var homeViewModel: HomeViewModel
    private val adapter = PostAdapter(sales)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        homeViewModel.sales.observe(this, Observer { list ->
            sales.clear()
            sales.addAll(list)
            adapter.notifyDataSetChanged() })

        this.home_recyclerview_sales.adapter = adapter
        this.home_recyclerview_sales.layoutManager = LinearLayoutManager(this)

        homeViewModel.fetchHotestSales()
    }
}
