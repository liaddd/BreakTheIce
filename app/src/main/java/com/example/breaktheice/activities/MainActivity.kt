package com.example.breaktheice.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.breaktheice.R
import com.example.breaktheice.fragments.CategoriesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_activity_frame_layout, CategoriesFragment.newInstance())
                .commit()
        }

    }


}
