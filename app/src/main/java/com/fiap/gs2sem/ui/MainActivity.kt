package com.fiap.gs2sem.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.fiap.gs2sem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var registerBtn: AppCompatButton
    private lateinit var prontBtn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        initListeners()

        setContentView(binding.root)
    }

    private fun initListeners() {
        registerBtn = binding.mainActivityRegister
        prontBtn = binding.mainActivityPront

        registerBtn.setOnClickListener {
            val intent = Intent(this, AppointmentRegisterActivity::class.java)
            startActivity(intent)
        }

        prontBtn.setOnClickListener {

        }
    }

}