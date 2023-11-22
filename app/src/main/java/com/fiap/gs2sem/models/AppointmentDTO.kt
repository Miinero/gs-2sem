package com.fiap.gs2sem.models

data class AppointmentDTO(val firebaseId: String, val name: String, val date: String, val cpf: String, val medicalType: String, val description: String, val medicalRecord: MedicalRecord?)