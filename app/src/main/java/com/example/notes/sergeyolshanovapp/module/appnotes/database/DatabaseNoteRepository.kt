package com.example.notes.sergeyolshanovapp.module.appnotes.database

import androidx.lifecycle.LiveData
import com.example.notes.sergeyolshanovapp.module.appnotes.model.AppNote

interface DatabaseNoteRepository {

    val allNotes: LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess:() -> Unit)
    suspend fun delete(note: AppNote, onSuccess:() -> Unit)
}