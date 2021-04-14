package com.galihmayangga.myapplication

import PreferenceUtil
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {

    private lateinit var buttonNext: Button
    private lateinit var tvWelcome: TextView

    lateinit var prefUtil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        prefUtil = PreferenceUtil.newInstance(this)

        if (!prefUtil.getBoolean("is_login")) {
            val intentWelcomeActivity = Intent(this, WelcomeActivity::class.java)
            startActivity(intentWelcomeActivity)
        }



        buttonNext = findViewById(R.id.btn_next)
        tvWelcome = findViewById(R.id.tv_welcome)


        buttonNext.setOnClickListener {
            val intentMainActivity = Intent(this, MainActivity::class.java).apply{
            }
            startActivity(intentMainActivity)
        }



        updateData()


    }

    private fun updateData() {
        val nama = prefUtil.getSring("nama")
        val welcomeMessage = "selamat datang, $nama"
        tvWelcome.text = welcomeMessage
        if (nama.isNullOrEmpty()) {
            tvWelcome.visibility = View.GONE
        } else {
            tvWelcome.visibility = View.VISIBLE
        }
    }
}