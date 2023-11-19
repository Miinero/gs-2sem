package com.fiap.gs2sem.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.fiap.gs2sem.R
import com.fiap.gs2sem.databinding.ActivityRegisterAppointBinding
import com.fiap.gs2sem.utils.FieldChecker
import com.fiap.gs2sem.watchers.CPFInputWatcher
import java.util.Calendar


class AppointmentRegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterAppointBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterAppointBinding.inflate(layoutInflater)

        initDatePickerListener()
        initSpinner()
        initCPFTextWatcher()
        initSubmitButton()

        setContentView(binding.root)
    }

    private fun initSubmitButton() {
        val button = binding.registerActivityButtonSubmit
        button.setOnClickListener {
            var ok = true

            val nameLayout = binding.registerActivityLayoutName
            val name = binding.registerActivityEdttextName.text.toString()
            if (!FieldChecker.checkName(name)) {
                ok = false

                nameLayout.error = "Insira um nome válido"
            }else nameLayout.error = null

            val dateEdttxt = binding.registerActivityEdttextDate
            val date = dateEdttxt.text.toString()
            if (!FieldChecker.checkDate(date)) {
                ok = false

                dateEdttxt.error = ""
            }else dateEdttxt.error = null

            val cpfLayout = binding.registerActivityLayoutCpf
            val cpf = binding.registerActivityEdttextCpf.text.toString()
            if (!FieldChecker.checkCPF(cpf)) {
                ok = false

                cpfLayout.error = "Insira um CPF válido"
            }else cpfLayout.error = null

            val descLayout = binding.registerActivityLayoutDesc
            val desc = binding.registerActivityEdttextDesc.text.toString()
            if (!FieldChecker.checkDesc(desc)) {
                ok = false

                descLayout.error = "Descreva o motivo da consulta"
            }else descLayout.error = null

            val spinner = binding.registerActivitySpinner
            val type = spinner.selectedItem.toString()

            if (!ok) return@setOnClickListener



        }
    }

    private fun initCPFTextWatcher() {
        val cpfEdt = binding.registerActivityEdttextCpf
        cpfEdt.addTextChangedListener(CPFInputWatcher())
    }

    private fun initSpinner() {
        val spinner = binding.registerActivitySpinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
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
                editTextDate.error = null
            }, year, month, day)

            datePickerDialog.show()
        }
    }

}