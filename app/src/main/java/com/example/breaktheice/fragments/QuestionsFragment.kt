package com.example.breaktheice.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.breaktheice.R
import com.example.breaktheice.adapters.QuestionAdapter
import com.example.breaktheice.models.Question
import com.example.breaktheice.viewmodels.QuestionViewModel
import kotlinx.android.synthetic.main.fragment_questions.*


class QuestionsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: QuestionAdapter
    private var questions: MutableList<Question> = mutableListOf()
    private var position: Int = 0
    private lateinit var questionViewModel: QuestionViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // todo - Liad create repo and fetch questions by filter (example below)
        /** todo https://question-something-api.herokuapp.com/api/questions?filter={"difficulties":["5dfe19a0da1f33bdd952f647"],"categories":["5e072b19da1f33bdd91d429f"]}*/

        val bundle = arguments
        if (bundle != null) {
            // todo Liad - get Category by difficulties and categories Arrays question using ViewModel
            //val difficultyId = category.difficulties.first().id
            questionViewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)
            /*questionViewModel.getQuestions(categoryId , difficultyId).observe(this, Observer {

            })*/
        }
        initRecyclerView()
        setListeners()
    }

    private fun setListeners() {
        fragment_questions_next_button.setOnClickListener {
            if (position < 9) ++position
            else position = 0
            recyclerView.smoothScrollToPosition(position)
        }
    }

    private fun initRecyclerView() {

        if (questions.isNullOrEmpty()) {
            repeat(10) {
                questions.add(Question(it.inc().toString(), "Question no ${it + 1}", (it + 1), (it + 1)))
            }
        }
        recyclerView = fragment_questions_recycler_view
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        adapter = QuestionAdapter(questions)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    companion object {
        fun newInstance(): QuestionsFragment {
            return QuestionsFragment()
        }
    }


}
