package com.example.breaktheice.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breaktheice.R
import com.example.breaktheice.models.Difficulty
import com.example.breaktheice.utils.extensions.clearAndAddAll
import com.example.breaktheice.utils.extensions.inflate

class DifficultyAdapter : RecyclerView.Adapter<DifficultyAdapter.ViewHolder>() {


    private var difficulties: MutableList<Difficulty> = mutableListOf()
    var listener: IDifficultyOnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.category_list_item))
    }

    override fun getItemCount(): Int {
        return difficulties.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val difficulty = difficulties[position]

        holder.difficultyTitle.text = difficulty.key
        holder.itemView.setOnClickListener { listener?.onCategoryClick(difficulty) }
    }

    fun setDifficulty(difficultyList: List<Difficulty>) {
        difficulties.clearAndAddAll(difficultyList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var difficultyImage: ImageView = itemView.findViewById(R.id.category_list_item_image_view)
        var difficultyTitle: TextView = itemView.findViewById(R.id.category_list_item_text_view)
    }

    interface IDifficultyOnClickListener {
        fun onCategoryClick(difficulty: Difficulty)
    }
}