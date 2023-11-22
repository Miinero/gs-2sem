package com.fiap.gs2sem.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.fiap.gs2sem.databinding.ActivityRecordsListBinding
import com.fiap.gs2sem.models.AppointmentDTO
import com.fiap.gs2sem.models.MedicalRecord
import com.fiap.gs2sem.recyclerview.RecyclerViewAdapter

class MedicalRecordsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecordsListBinding
    private lateinit var recycler: RecyclerView
    private lateinit var appointsList: ArrayList<AppointmentDTO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecordsListBinding.inflate(layoutInflater)

        appointsList = ArrayList()
        appointsList.add(AppointmentDTO("asd", "João", "asd", "sf", "df", "dfsdf", MedicalRecord("asd", 12, "asdasd", "asdasd", "sdfsdf")))
        appointsList.add(AppointmentDTO("asd", "Isac", "asd", "sf", "df", "dfsdf", null))
        appointsList.add(AppointmentDTO("Essej", "João", "asd", "sf", "df", "dfsdf", MedicalRecord("asd", 12, "asdasd", "asdasd", "sdfsdf")))

        initComponents()

        setContentView(binding.root)
    }

    private fun initComponents() {

        recycler = binding.activityRecordsRecyclerview
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = RecyclerViewAdapter(appointsList)

    }

}