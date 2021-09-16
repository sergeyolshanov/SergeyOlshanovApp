package com.example.notes.sergeyolshanovapp.module.app_notes.database.firebase

import androidx.lifecycle.LiveData
import com.example.notes.sergeyolshanovapp.module.app_notes.database.DatabaseNoteRepository
import com.example.notes.sergeyolshanovapp.module.app_notes.model.AppNote
import com.example.notes.utilits.EMAIL
import com.example.notes.utilits.PASSWORD
import com.google.firebase.auth.FirebaseAuth

class AppNoteFirebaseRepository : DatabaseNoteRepository {

    private val mAuth = FirebaseAuth.getInstance()

    override val allNotes: LiveData<List<AppNote>>
        get() = TODO("Not yet implemented")

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {

    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {

    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(EMAIL?: "", PASSWORD?: "")
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(EMAIL?: "", PASSWORD?: "")
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }
    }

    override fun singOut() {
        mAuth.signOut()
    }
}