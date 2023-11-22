package com.fiap.gs2sem.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import com.fiap.gs2sem.R
import com.fiap.gs2sem.models.AppointmentDTO

class RecyclerViewAdapter(private val appointsList: ArrayList<AppointmentDTO>):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_records_record, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = appointsList[position]
        holder.nameWidget.text = currentItem.name

        val imgId: Int = if (currentItem.medicalRecord != null) {
            R.drawable.baseline_check_24
        } else {
            R.drawable.baseline_hourglass_bottom_24
        }

        holder.btnStatusWidget.setImageResource(imgId)

        val backgroundId = if (currentItem.medicalRecord != null) {
            R.drawable.custom_checked_button_border
        } else {
            R.drawable.custom_waiting_button_border
        }

        holder.btnStatusWidget.setBackgroundResource(backgroundId)
    }

    override fun getItemCount(): Int {
        return appointsList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameWidget: TextView = itemView.findViewById(R.id.record_username)
        val btnStatusWidget: AppCompatImageButton = itemView.findViewById(R.id.record_btn_status)
    }
}