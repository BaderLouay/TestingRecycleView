package com.baderlouay.monmedecin.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baderlouay.monmedecin.Repository.DoctorRepository

class DoctorViewModel : ViewModel() {

    private val repository : DoctorRepository
    private val _allDoctors = MutableLiveData<List<Doctors>>()
    val allDoctors : LiveData<List<Doctors>> = _allDoctors


    init {
        repository = DoctorRepository().getInstance()
        repository.loadDoctors(_allDoctors)
    }

}