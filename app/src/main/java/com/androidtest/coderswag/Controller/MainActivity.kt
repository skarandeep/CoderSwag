package com.androidtest.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.translation.ViewTranslationRequest
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import com.androidtest.coderswag.Adapters.CategoryAdapter
import com.androidtest.coderswag.Model.Category
import com.androidtest.coderswag.R
import com.androidtest.coderswag.Services.DataService

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)

        val categoryListView = findViewById<ListView>(R.id.categoryListView)
        categoryListView.adapter = adapter

    }
}