package com.example.notes.sergeyolshanovapp.module.app_notes.database.firebase

import androidx.lifecycle.LiveData
import com.example.notes.sergeyolshanovapp.module.app_notes.model.AppNote
import com.example.notes.utilits.REF_DATABASE
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AllNotesLiveData: LiveData<List<AppNote>>() {

    private val listener = object : ValueEventListener{

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }

        override fun onDataChange(snapshot: DataSnapshot) {
            value = snapshot.children.map {
                it.getValue(AppNote::class.java)?: AppNote()
            }
        }


    }

    override fun onActive() {
        REF_DATABASE?.addValueEventListener(listener)
        super.onActive()
    }

    override fun onInactive() {
        REF_DATABASE?.removeEventListener(listener)
        super.onInactive()
    }
}