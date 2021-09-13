package com.example.notes.sergeyolshanovapp.module.appnotes.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.sergeyolshanovapp.module.appnotes.model.AppNote
import com.google.android.material.circularreveal.CircularRevealHelper

@Dao
interface AppNoteRoomDao {
    @Query("SELECT * FROM notes_tables")
    fun getAllNotes(): LiveData<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: AppNote)

    @Delete
    suspend fun delete(note: AppNote)
}