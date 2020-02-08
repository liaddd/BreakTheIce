package com.example.breaktheice.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.breaktheice.R
import com.example.breaktheice.adapters.CategoryAdapter
import com.example.breaktheice.extensions.changeFragment
import com.example.breaktheice.extensions.toast
import com.example.breaktheice.models.Category
import com.example.breaktheice.viewmodels.SplashActivityViewModel
import kotlinx.android.synthetic.main.fragment_categories.*
import org.koin.android.ext.android.inject
import java.util.*

class CategoriesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val SPAN_COUNT: Int = 2
    private var categoryList = ArrayList<Category>()
    private lateinit var categoryAdapter: CategoryAdapter

    private val viewModel: SplashActivityViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setObservable()
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun setObservable() {

        viewModel.getCategoriesLiveData().observe(this, Observer {
            Log.d("Liad", "in getCategoriesLiveData observe DATA: $it")
            if (!it.isNullOrEmpty()) {
                categoryAdapter.setCategories(it as ArrayList<Category>)
            } else {
                toast(context, "Sorry no Data to show O_o")
            }
        })
    }

    private fun initView() {
        recyclerView = start_fragment_recycler_view
        recyclerView.layoutManager = GridLayoutManager(context, SPAN_COUNT, RecyclerView.VERTICAL, false)
        categoryAdapter = CategoryAdapter(categoryList)
        recyclerView.adapter = categoryAdapter
        categoryAdapter.onItemClick = {
            changeFragment(
                activity!!.supportFragmentManager,
                QuestionsFragment.newInstance(),
                null,
                true
            )
        }

    }

    companion object {
        fun newInstance(): CategoriesFragment {
            return CategoriesFragment()
        }
    }
}
