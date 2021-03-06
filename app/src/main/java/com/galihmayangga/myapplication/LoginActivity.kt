package com.galihmayangga.myapplication

import PreferenceUtil
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    lateinit var etNama: EditText
    lateinit var btnSubmit: Button

    lateinit var prefUtil: PreferenceUtil


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        prefUtil = PreferenceUtil.newInstance(this)

        etNama = findViewById(R.id.et_nama)
        btnSubmit = findViewById(R.id.btn_submit)

        etNama.setText(prefUtil.getSring("nama"))
        btnSubmit.setOnClickListener {
            saveData()
            val intentWelcomeActivityActivity = Intent(this, WelcomeActivity::class.java).apply{
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intentWelcomeActivityActivity)
        }



    }

    private fun saveData() {
        val nama = etNama.text.toString().trim()
        prefUtil.setString("nama", nama)
        prefUtil.setBoolean("is_login", true)
    }

    }
