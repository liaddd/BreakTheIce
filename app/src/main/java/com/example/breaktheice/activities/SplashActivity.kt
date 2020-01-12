package com.example.breaktheice.activities

import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.breaktheice.R
import com.example.breaktheice.server_connection.CategoryResponse
import com.example.breaktheice.server_connection.DifficultiesResponse
import com.example.breaktheice.server_connection.RetrofitProvider
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val rotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
        splash_activity_loading_text_view.animation = rotate
        getCategoriesAndDifficulties()
        Handler().postDelayed({
            changeActivity(this, MainActivity::class.java, true)
        }, 2500)
    }

    private fun getCategoriesAndDifficulties() {
        RetrofitProvider.instance.getCategories().enqueue(object : Callback<CategoryResponse> {

            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                Toast.makeText(applicationContext, "" + response.body()!!.getResults(), Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "" + t.message, Toast.LENGTH_LONG).show()
            }

        })


        RetrofitProvider.instance.getDifficulties().enqueue(object : Callback<DifficultiesResponse> {

            override fun onResponse(call: Call<DifficultiesResponse>, response: Response<DifficultiesResponse>) {
                Toast.makeText(applicationContext, "" + response.body()!!.getResults(), Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<DifficultiesResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "" + t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}
