package com.example.notes.sergeyolshanovapp.module.appnotes.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.notes.sergeyolshanovapp.module.appnotes.database.room.AppNoteRoomDatabase
import com.example.notes.sergeyolshanovapp.module.appnotes.database.room.AppNoteRoomRepository
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