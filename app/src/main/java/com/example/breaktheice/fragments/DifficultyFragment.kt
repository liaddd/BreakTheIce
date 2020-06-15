package com.example.breaktheice.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.breaktheice.R

class DifficultyFragment : Fragment() {


    companion object {
        fun newInstance(bundle: Bundle? = null): DifficultyFragment {
            val difficultyFragment = DifficultyFragment()
            if (bundle != null) difficultyFragment.arguments = bundle
            return difficultyFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_difficulty, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {

    }

}
