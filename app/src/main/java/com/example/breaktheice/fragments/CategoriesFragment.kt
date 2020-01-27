package com.example.breaktheice.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.breaktheice.R
import com.example.breaktheice.adapters.CategoryAdapter
import com.example.breaktheice.di.viewmodel_factory_di.DaggerIMyFactoryComponent
import com.example.breaktheice.models.Category
import com.example.breaktheice.utils.Constants
import com.example.breaktheice.utils.Toast
import com.example.breaktheice.utils.changeFragment
import com.example.breaktheice.viewmodels.SplashActivityViewModel
import kotlinx.android.synthetic.main.fragment_categories.*
import java.util.*
import javax.inject.Inject

class CategoriesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val SPAN_COUNT: Int = 2
    private var categoryList = ArrayList<Category>()
    private lateinit var categoryAdapter: CategoryAdapter

    @Inject
    lateinit var factory : ViewModelProvider.Factory
    lateinit var viewModel: SplashActivityViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerIMyFactoryComponent.create().inject(this)
        setObservable()
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun setObservable() {
        viewModel = ViewModelProviders.of(this , factory).get(SplashActivityViewModel::class.java)
        viewModel.getCategoriesLiveData().observe(this, Observer {
            Log.d("Liad", "in getCategoriesLiveData observe DATA: $it")
            if (!it.isNullOrEmpty()) {
                categoryAdapter.setCategories(it as ArrayList<Category>)
            } else {
                Toast(context, "Sorry no Data to show O_o", 2000)
            }
        })
    }

    private fun initView() {
        recyclerView = start_fragment_recycler_view
        recyclerView.layoutManager = GridLayoutManager(context, SPAN_COUNT, RecyclerView.VERTICAL, false)
        categoryAdapter = CategoryAdapter(categoryList)
        recyclerView.adapter = categoryAdapter
        categoryAdapter.onItemClick = { category ->
            val bundle = Bundle()
            bundle.putParcelable(Constants.CATEGORY, category)
            changeFragment(activity!!.supportFragmentManager, QuestionsFragment.newInstance(), bundle, true)
        }

    }

    companion object {
        fun newInstance(): CategoriesFragment {
            return CategoriesFragment()
        }
    }
}
