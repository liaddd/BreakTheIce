package com.example.breaktheice.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breaktheice.R
import com.example.breaktheice.extensions.inflate
import com.example.breaktheice.models.Question

class QuestionAdapter(private val questions: List<Question>) : RecyclerView.Adapter<QuestionAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(parent.inflate(R.layout.question_item, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val questionObj = questions[position]
        holder.questionText.text = questionObj.question
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var questionText: TextView = itemView.findViewById(R.id.question_item_card_text_view)
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}
