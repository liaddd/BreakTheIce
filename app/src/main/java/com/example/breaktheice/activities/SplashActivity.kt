package com.example.breaktheice.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import co.climacell.statefulLiveData.core.StatefulData
import com.example.breaktheice.R
import com.example.breaktheice.utils.extensions.toast
import com.example.breaktheice.viewmodels.CategoriesViewModel
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {


    private val viewModel: CategoriesViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setObservables()
    }

    private fun setObservables() {
        viewModel.getCategories().observe(this , Observer {
            when (it) {
                is StatefulData.Success -> continueFlow()
                is StatefulData.Loading -> splash_activity_progress_bar.visibility = View.VISIBLE
                is StatefulData.Error -> toast(this , it.throwable.localizedMessage)
            }
        })
    }

    private fun continueFlow() {
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}
