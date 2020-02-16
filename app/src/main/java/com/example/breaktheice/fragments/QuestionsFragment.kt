package com.example.breaktheice.fragments


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.breaktheice.R
import com.example.breaktheice.adapters.QuestionAdapter
import com.example.breaktheice.models.Question
import com.example.breaktheice.viewmodels.QuestionViewModel
import kotlinx.android.synthetic.main.fragment_questions.*
import org.koin.android.ext.android.inject


class QuestionsFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance(): QuestionsFragment {
            return QuestionsFragment()
        }
    }

    private lateinit var recyclerView: RecyclerView

    private val questionAdapter: QuestionAdapter = QuestionAdapter()
    private val questionViewModel: QuestionViewModel by inject()

    // todo Liad - Remove -> ONLY for testing
    private var questions: MutableList<Question> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_questions, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // todo https://question-something-api.herokuapp.com/api/questions?filter={"difficulties":["5dfe19a0da1f33bdd952f647"],"categories":["5e072b19da1f33bdd91d429f"]}*/
        initViews()
        setObservers()
        setListeners()
    }

    private fun initViews() {

        // todo Liad - replace with real list from Observation
        if (questions.isNullOrEmpty()) {
            repeat(10) {
                questions.add(Question(it.inc().toString(), "Question no ${it + 1}", (it + 1), (it + 1)))
            }
        }
        questionAdapter.setQuestions(questions)

        recyclerView = fragment_questions_recycler_view
        recyclerView.apply {
            adapter = questionAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }

    private fun setListeners() {

        fragment_questions_like_image_view.setOnClickListener(this)
        fragment_questions_dislike_image_view.setOnClickListener(this)

        fragment_questions_next_button.setOnClickListener {
            moveToNextItem()
        }
    }

    private fun setObservers() {
        questionViewModel.getQuestions("", "").observe(viewLifecycleOwner, Observer {
            //TODO("not implemented")
        })
    }

    private fun moveToNextItem() {
        var currentPosition =
            (recyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
        if (currentPosition < 9) ++currentPosition
        else currentPosition = 0
        recyclerView.smoothScrollToPosition(currentPosition)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fragment_questions_like_image_view -> {
                onLikeClicked()
            }
            R.id.fragment_questions_dislike_image_view -> {
                onDislikeClicked()
            }
        }
    }

    private fun onLikeClicked() {

        val currentPosition =
            (recyclerView.layoutManager as? LinearLayoutManager)?.findFirstCompletelyVisibleItemPosition()
        val currentView = (recyclerView.layoutManager as LinearLayoutManager).findViewByPosition(currentPosition ?: 0)
        currentView?.let {
            YoYo.with(Techniques.Landing)
                .duration(1000)
                .playOn(currentView)
        }
        Handler().postDelayed({
            moveToNextItem()
        }, 500)
    }

    private fun onDislikeClicked() {
        val currentPosition =
            (recyclerView.layoutManager as? LinearLayoutManager)?.findFirstCompletelyVisibleItemPosition()
        val currentView = (recyclerView.layoutManager as LinearLayoutManager).findViewByPosition(currentPosition ?: 0)
        currentView?.let {
            YoYo.with(Techniques.Wobble)
                .duration(1000)
                .playOn(currentView)
        }
        Handler().postDelayed({
            moveToNextItem()
        }, 500)
    }

}
