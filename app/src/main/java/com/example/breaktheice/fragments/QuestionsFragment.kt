package com.example.breaktheice.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.breaktheice.R
import com.example.breaktheice.adapters.QuestionAdapter
import com.example.breaktheice.models.Question
import kotlinx.android.synthetic.main.fragment_questions.*


class QuestionsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questions: MutableList<Question> = mutableListOf()
        repeat(10) {
            questions.add(Question(it.inc(), "Question no ${it + 1}", (it + 1), (it + 1)))
        }
        val recyclerView = fragment_questions_recycler_view
        val snapHelper : SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        val adapter = QuestionAdapter(questions , object : QuestionAdapter.OnItemClickListener{
            override fun onItemClick(item: Question) {
                recyclerView.smoothScrollToPosition(item.id)
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)

    }

    companion object {
        fun newInstance(): QuestionsFragment {
            return QuestionsFragment()
        }
    }


}
