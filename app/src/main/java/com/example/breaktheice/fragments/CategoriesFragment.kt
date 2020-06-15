package com.example.breaktheice.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.climacell.statefulLiveData.core.StatefulData
import com.example.breaktheice.R
import com.example.breaktheice.adapters.CategoryAdapter
import com.example.breaktheice.models.Category
import com.example.breaktheice.utils.extensions.changeFragment
import com.example.breaktheice.viewmodels.CategoriesViewModel
import kotlinx.android.synthetic.main.fragment_categories.*
import org.koin.android.ext.android.inject


const val SPAN_COUNT: Int = 2

class CategoriesFragment : Fragment() {

    companion object {
        fun newInstance(): CategoriesFragment {
            return CategoriesFragment()
        }
    }

    private val categoryAdapter = CategoryAdapter().apply { listener = onCategoryClickListener() }
    private lateinit var progressBar: ProgressBar
    private val viewModel: CategoriesViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(R.layout.fragment_categories, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setObservable()
    }

    private fun setObservable() {

        viewModel.getCategories().observe(this, Observer {
            Log.d("Liad", "in getCategoriesLiveData : $it")
            when (it) {
                is StatefulData.Success -> {
                    progressBar.visibility = View.GONE
                    categoryAdapter.setCategories(it.data)
                }
                is StatefulData.Loading -> progressBar.visibility = View.VISIBLE
                is StatefulData.Error -> progressBar.visibility = View.VISIBLE

            }
        })
    }

    private fun initView() {
        progressBar = categories_fragment_progress_bar
        val recyclerView = categories_fragment_recycler_view
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, SPAN_COUNT, RecyclerView.VERTICAL, false)
            adapter = categoryAdapter
        }
    }

    private fun onCategoryClickListener(): CategoryAdapter.ICategoryOnClickListener? =
        object : CategoryAdapter.ICategoryOnClickListener {
            override fun onCategoryClick(category: Category) {
                activity?.let {
                    changeFragment(
                        it.supportFragmentManager,
                        DifficultyFragment.newInstance(),
                        addToStack = true
                    )
                }
            }
        }
}
