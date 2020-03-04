package com.example.breaktheice.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.breaktheice.R
import com.example.breaktheice.fragments.CategoriesFragment
import com.example.breaktheice.utils.extensions.changeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            changeFragment(supportFragmentManager, CategoriesFragment.newInstance())
        }
    }
}
