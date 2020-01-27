package com.example.breaktheice.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breaktheice.R
import com.example.breaktheice.models.Category
import com.example.breaktheice.utils.inflate

class CategoryAdapter(private var categories: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var onItemClick: ((Category) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.category_list_item))
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val categoryObj = categories[position]

        holder.categoryTitle.text = categoryObj.key
    }

    fun setCategories(categoryList: ArrayList<Category>) {
        categories = categoryList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var categoryImage: ImageView = itemView.findViewById(R.id.category_list_item_image_view)
        var categoryTitle: TextView = itemView.findViewById(R.id.category_list_item_text_view)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(categories[adapterPosition])
            }
        }
    }
}