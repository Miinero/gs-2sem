package com.fiap.gs2sem.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fiap.gs2sem.databinding.ActivityRecordsListBinding

class MedicalRecordsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecordsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecordsListBinding.inflate(layoutInflater)

        initListeners()

        setContentView(binding.root)
    }

    private fun initListeners() {

    }

}