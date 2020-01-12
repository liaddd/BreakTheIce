package com.example.breaktheice.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breaktheice.R
import com.example.breaktheice.models.Question
import com.example.breaktheice.utils.inflate

class QuestionAdapter(private val questions: List<Question> , private val listener : OnItemClickListener) :
    RecyclerView.Adapter<QuestionAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflatedView = parent.inflate(R.layout.question_item, false)

        return MyViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val questionObj = questions[position]

        holder.bind(questionObj , listener)
        holder.questionText.text = questionObj.question

    }

    interface OnItemClickListener {
        fun onItemClick(item: Question)
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var questionText: TextView = itemView.findViewById(R.id.question_item_card_text_view)
        var likeText: TextView = itemView.findViewById(R.id.question_item_like_text_view)
        var nextText: TextView = itemView.findViewById(R.id.question_item_next_text_view)
        var dislikeText: TextView = itemView.findViewById(R.id.question_item_dislike_text_view)
        var image: ImageView = itemView.findViewById(R.id.question_item_image_view)

        fun bind(item : Question, listener : OnItemClickListener) {
            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }
}