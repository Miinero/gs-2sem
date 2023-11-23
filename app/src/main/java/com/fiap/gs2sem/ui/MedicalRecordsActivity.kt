package com.fiap.gs2sem.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fiap.gs2sem.databinding.ActivityRecordsListBinding
import com.fiap.gs2sem.models.AppointmentDTO
import com.fiap.gs2sem.models.MedicalRecord
import com.fiap.gs2sem.recyclerview.RecyclerViewAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MedicalRecordsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecordsListBinding
    private lateinit var recycler: RecyclerView
    private lateinit var appointsList: ArrayList<AppointmentDTO>
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecordsListBinding.inflate(layoutInflater)

        appointsList = ArrayList()

        database = FirebaseDatabase.getInstance().getReference("appoints")

        loadFirebaseList()

        setContentView(binding.root)
    }

    private fun loadFirebaseList() {
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (childSnapshot in dataSnapshot.children) {
                    val id: String = childSnapshot.child("firebaseId").getValue(String::class.java) ?: ""
                    val name: String = childSnapshot.child("name").getValue(String::class.java) ?: ""
                    val date: String = childSnapshot.child("date").getValue(String::class.java) ?: ""
                    val cpf: String = childSnapshot.child("cpf").getValue(String::class.java) ?: ""
                    val medicalType: String = childSnapshot.child("medicalType").getValue(String::class.java) ?: ""
                    val desc: String = childSnapshot.child("description").getValue(String::class.java) ?: ""
                    val medicalRecord: MedicalRecord? = childSnapshot.child("medicalRecord").getValue(MedicalRecord::class.java)


                    val appointmentDTO = AppointmentDTO(id, name, date, cpf, medicalType, desc, medicalRecord)

                    appointsList.add(appointmentDTO)
                }

                Log.i("DatabaseDebug", "Lista de Appointments: $appointsList")

                initRecyclerView()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("DatabaseDebug", "Falha ao ler dados.", databaseError.toException())
            }
        })
    }

    private fun initRecyclerView() {

        recycler = binding.activityRecordsRecyclerview
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = RecyclerViewAdapter(appointsList, database)

    }

}