package com.example.notes.sergeyolshanovapp.module.app_notes.database.room

import androidx.lifecycle.LiveData
import com.example.notes.sergeyolshanovapp.module.app_notes.database.DatabaseNoteRepository
import com.example.notes.sergeyolshanovapp.module.app_notes.model.AppNote

class AppNoteRoomRepository(private val appNoteRoomDao: AppNoteRoomDao) : DatabaseNoteRepository {

    override val allNotes: LiveData<List<AppNote>>
        get() = appNoteRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appNoteRoomDao.insert(note)
        onSuccess()
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appNoteRoomDao.delete(note)
        onSuccess()
    }


}