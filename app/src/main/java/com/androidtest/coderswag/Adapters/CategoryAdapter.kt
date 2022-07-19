package com.androidtest.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidtest.coderswag.Model.Category
import com.androidtest.coderswag.R

class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder: ViewHolder

        if (convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)

            holder = ViewHolder()       //initializing holder

            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)

        // these lines modified above    val categoryImage: ImageView = categoryView.findViewById(R.id.categoryImage)
        //    val categoryName: TextView = categoryView.findViewById(R.id.categoryName)

            println("I exist for the first time!")

            categoryView.tag = holder
        } else {
            //holder is already created
            holder = convertView.tag as ViewHolder
            categoryView = convertView
            println("Go green recycle!")
        }

     //   categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
     //   val categoryImage: ImageView = categoryView.findViewById(R.id.categoryImage)
     //   val categoryName: TextView = categoryView.findViewById(R.id.categoryName)
       // println("Heavy computing")

        val category = categories[position]

        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        // categoryImage.setImageResource(resourceId)
        holder.categoryImage?.setImageResource(resourceId)
        // println(resourceId)

        // categoryName.text = category.title
        holder.categoryName?.text = category.title
        return categoryView
    }

    override fun getItem(position: Int): Any {
    return categories[position]
    }

    override fun getItemId(position: Int): Long {
    return 0  //unique ID for each row
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }

}