package com.baderlouay.monmedecin.test/*package com.baderlouay.monmedecin.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baderlouay.monmedecin.Adapter.MyAdapter
import com.baderlouay.monmedecin.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DoctorListActivity : ComponentActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var doctorRecyclerview : RecyclerView
    private lateinit var doctorArrayList : ArrayList<Doctors>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctorlist)

        doctorRecyclerview = findViewById(R.id.doctorList)
        doctorRecyclerview.layoutManager = LinearLayoutManager(this)
        doctorRecyclerview.setHasFixedSize(true)

        doctorArrayList = arrayListOf<Doctors>()
        getDoctorData()


    }

    private fun getDoctorData() {

        dbref = FirebaseDatabase.getInstance().getReference("Doctors")

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (doctoSnapshot in snapshot.children){

                        val doctor = doctoSnapshot.getValue(Doctors::class.java)
                        doctorArrayList.add(doctor!!)

                    }

                    doctorRecyclerview.adapter = MyAdapter(doctorArrayList)


                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}
*/
