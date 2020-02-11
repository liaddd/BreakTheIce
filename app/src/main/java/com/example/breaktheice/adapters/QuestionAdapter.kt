package com.example.breaktheice.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breaktheice.R
import com.example.breaktheice.models.Question
import com.example.breaktheice.utils.extensions.clearAndAddAll
import com.example.breaktheice.utils.extensions.inflate

class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.MyViewHolder>() {


    private val questions = mutableListOf<Question>()

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

    fun setQuestions(questions : List<Question>) {
        this.questions.clearAndAddAll(questions)
        notifyDataSetChanged()
    }
}
