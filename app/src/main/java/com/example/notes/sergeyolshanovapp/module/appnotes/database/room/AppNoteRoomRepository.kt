package com.example.notes.sergeyolshanovapp.module.appnotes.database.room

import androidx.lifecycle.LiveData
import com.example.notes.sergeyolshanovapp.module.appnotes.database.DatabaseNoteRepository
import com.example.notes.sergeyolshanovapp.module.appnotes.model.AppNote

class AppNoteRoomRepository(private val appNoteRoomDao: AppNoteRoomDao) : DatabaseNoteRepository {

    override val allNotes: LiveData<List<AppNote>>
        get() = appNoteRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appNoteRoomDao.insert(note)
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appNoteRoomDao.delete(note)
    }
}