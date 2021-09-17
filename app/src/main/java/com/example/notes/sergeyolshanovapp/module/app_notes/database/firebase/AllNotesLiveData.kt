package com.example.notes.sergeyolshanovapp.module.app_notes.database.firebase

import androidx.lifecycle.LiveData
import com.example.notes.sergeyolshanovapp.module.app_notes.model.AppNote
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AllNotesLiveData: LiveData<List<AppNote>>() {
    private val mAuth = FirebaseAuth.getInstance()
    private val mDatabaseNoteRepository = FirebaseDatabase.getInstance().reference
        .child(mAuth.currentUser?.uid.toString())
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
        mDatabaseNoteRepository.addValueEventListener(listener)
        super.onActive()
    }

    override fun onInactive() {
        mDatabaseNoteRepository.removeEventListener(listener)
        super.onInactive()
    }
}