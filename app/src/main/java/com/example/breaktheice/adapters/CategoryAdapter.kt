package com.example.breaktheice.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breaktheice.R
import com.example.breaktheice.models.Category
import com.example.breaktheice.utils.extensions.inflate

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    private var categories: List<Category> = emptyList()
    var listener: ICategoryOnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.category_list_item))
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]

        holder.categoryTitle.text = category.key
        holder.itemView.setOnClickListener { listener?.onCategoryClick(category) }
    }

    fun setCategories(categoryList: List<Category>) {
        categories = categoryList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categoryImage: ImageView = itemView.findViewById(R.id.category_list_item_image_view)
        var categoryTitle: TextView = itemView.findViewById(R.id.category_list_item_text_view)
    }

    interface ICategoryOnClickListener {
        fun onCategoryClick(category: Category)
    }
}