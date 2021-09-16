package com.example.notes.sergeyolshanovapp.module.app_notes.database

import androidx.lifecycle.LiveData
import com.example.notes.sergeyolshanovapp.module.app_notes.model.AppNote

interface DatabaseNoteRepository {

    val allNotes: LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess:() -> Unit)
    suspend fun delete(note: AppNote, onSuccess:() -> Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit){}

    fun singOut(){
    }
}