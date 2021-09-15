package com.example.notes.sergeyolshanovapp.module.app_notes.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notes.sergeyolshanovapp.module.app_notes.database.room.AppNoteRoomDatabase
import com.example.notes.sergeyolshanovapp.module.app_notes.database.room.AppNoteRoomRepository
import com.example.notes.utilits.REPOSITORY
import com.example.notes.utilits.TYPE_ROOM

class StartNoteViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application

    fun initDatabase(type: String, onSuccess:() -> Unit) {
        when(type) {
            TYPE_ROOM -> {
                val dao = AppNoteRoomDatabase.getInstance(mContext).getAppNoteRoomDao()
                REPOSITORY = AppNoteRoomRepository(dao)
                onSuccess()
            }
        }
    }
}