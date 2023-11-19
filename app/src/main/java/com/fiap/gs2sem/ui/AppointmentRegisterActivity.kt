package com.fiap.gs2sem.ui

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fiap.gs2sem.databinding.ActivityRegisterAppointBinding
import java.util.Calendar


class AppointmentRegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterAppointBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterAppointBinding.inflate(layoutInflater)

        initDatePickerListener()

        setContentView(binding.root)
    }

    private fun initDatePickerListener() {
        val editTextDate = binding.registerActivityEdttextDate
        editTextDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "${selectedDay}/${selectedMonth + 1}/$selectedYear"
                editTextDate.setText(selectedDate)
            }, year, month, day)

            datePickerDialog.show()
        }
    }

}