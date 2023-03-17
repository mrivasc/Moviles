package com.mrivas.contactpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var contactButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()
    }

    private fun bind() {
        contactButton = findViewById(R.id.contact_button)
    }

    private fun addListener() {
        contactButton.setOnClickListener {
            var intent = Intent(MainActivity@this, ResultActivity::class.java)
            startActivity(intent)
        }
    }
}


