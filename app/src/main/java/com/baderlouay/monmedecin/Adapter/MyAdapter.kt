package com.baderlouay.monmedecin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baderlouay.monmedecin.Models.Doctors
import com.baderlouay.monmedecin.R



class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    private val doctorList = ArrayList<Doctors>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.doctor_item,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = doctorList[position]

        holder.doctor.text = currentitem.doctor
        holder.adress.text = currentitem.adress
        holder.spec.text = currentitem.spec

    }

    fun updateDoctorList(doctorList: List<Doctors>){

        this.doctorList.clear()
        this.doctorList.addAll(doctorList)
        notifyDataSetChanged()

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val doctor : TextView = itemView.findViewById(R.id.tvdoctor)
        val adress : TextView = itemView.findViewById(R.id.tvadress)
        val spec : TextView = itemView.findViewById(R.id.tvspec)

    }

}



/*

class MyAdapter (private val doctorList : ArrayList<Doctors>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.doctor_item,
        parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = doctorList [position]

        holder.doctor.text = currentitem.doctor
        holder.adress.text = currentitem.adress
        holder.spec.text = currentitem.spec


    }

    override fun getItemCount(): Int {

        return doctorList.size
    }




    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val adress : TextView = itemView.findViewById(R.id.tvadress)
        val doctor : TextView = itemView.findViewById(R.id.tvdoctor)
        val spec : TextView = itemView.findViewById(R.id.tvspec)

    }


}
*/
