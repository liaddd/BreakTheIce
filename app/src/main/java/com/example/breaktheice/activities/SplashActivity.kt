package com.example.breaktheice.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.breaktheice.R
import com.example.breaktheice.di.viewmodel_factory_di.DaggerIMyFactoryComponent
import com.example.breaktheice.di.viewmodel_factory_di.ViewModelFactory
import com.example.breaktheice.viewmodels.SplashActivityViewModel
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var viewModel: SplashActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        DaggerIMyFactoryComponent.create().inject(this)
        setObservables()
    }

    private fun setObservables() {
        viewModel = ViewModelProviders.of(this , factory).get(SplashActivityViewModel::class.java)
        viewModel.loadCategories()
        viewModel.getIsLoading().observe(this, Observer {
            if (it) {
                splash_activity_progress_bar.visibility = View.VISIBLE
            } else {
                splash_activity_progress_bar.visibility = View.GONE
                continueFlow()
            }
        })
    }

    private fun continueFlow() {
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}
