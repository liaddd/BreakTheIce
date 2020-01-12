package com.example.breaktheice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.breaktheice.R
import com.example.breaktheice.activities.MainActivity
import com.example.breaktheice.models.Category
import com.example.breaktheice.viewmodels.StartFragmentViewModel
import kotlinx.android.synthetic.main.fragment_start.*
import java.util.*

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProviders.of(this)[StartFragmentViewModel::class.java]
        viewModel.getCategories().observe(viewLifecycleOwner, Observer<List<Category>> { users ->
            Toast.makeText(context, Arrays.asList(users).toString(), Toast.LENGTH_LONG).show()
        })
        return inflater.inflate(R.layout.fragment_start, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

        /*RetrofitProvider.instance.getCategories().enqueue(object: Callback<CategoryResponse>{

            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                Toast.makeText(context , ""+ response.body() , Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Toast.makeText(context , ""+ t.message , Toast.LENGTH_LONG).show()

            }

        })*/
    }


    private fun initView() {

        // todo Liad - fix (supposed to get list from web request)
        val categoryList = listOf(
            "Select Category",
            "Category Number 1",
            "Category Number 2",
            "Category Number 3",
            "Category Number 4"
        )
        val difficultyList = listOf(
            "Select Difficulty",
            "Easy",
            "Medium",
            "Hard",
            "Extreme"
        )

        val categorySpinner = start_fragment_category_spinner
        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0) showDifficultySpinner()
            }

        }
        val difficultySpinner = start_fragment_difficulty_spinner
        difficultySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0) showNextButton()
            }

        }
        val categoryArrayAdapter = ArrayAdapter(context!!, R.layout.spinner_item, categoryList)
        categorySpinner.adapter = categoryArrayAdapter

        val difficultyArrayAdapter = ArrayAdapter(context!!, R.layout.spinner_item, difficultyList)
        difficultySpinner.adapter = difficultyArrayAdapter

        start_fragment_next_button.setOnClickListener {
            if (context is MainActivity) {
                (context as MainActivity).changeFragment(QuestionsFragment.newInstance(), true)
            }
        }

    }

    private fun showNextButton() {
        start_fragment_next_button.visibility = View.VISIBLE
    }


    private fun showDifficultySpinner() {
        start_fragment_difficulty_card_view.visibility = View.VISIBLE
    }

    companion object {
        fun newInstance(): StartFragment {
            return StartFragment()
        }
    }
}
