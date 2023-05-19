package com.baderlouay.monmedecin.Repository

import androidx.lifecycle.MutableLiveData
import com.baderlouay.monmedecin.Models.Doctors
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DoctorRepository {

    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance().getReference("Doctors")

    @Volatile private var INSTANCE : DoctorRepository?= null

    fun getInstance() : DoctorRepository {

        return INSTANCE ?: synchronized(this){

            val instance = DoctorRepository()
            INSTANCE = instance
            instance

        }

    }


    fun loadDoctors(doctorList: MutableLiveData<List<Doctors>>){

        databaseReference.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                try {

                    val _doctorList : List<Doctors> = snapshot.children.map { dataSnapshot ->

                        dataSnapshot.getValue(Doctors::class.java)!!
                    }

                    doctorList.postValue(_doctorList)

                }catch (e : Exception){

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

}