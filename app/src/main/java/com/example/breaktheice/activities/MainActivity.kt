package com.example.breaktheice.activities

import android.os.Bundle
import com.example.breaktheice.R
import com.example.breaktheice.fragments.StartFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragment(StartFragment.newInstance(), false)
    }



}
