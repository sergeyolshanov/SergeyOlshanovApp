package com.example.notes.sergeyolshanovapp.module.app_notes.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.sergeyolshanovapp.module.app_notes.model.AppNote

@Database(entities = [AppNote::class], version = 1)
abstract class AppNoteRoomDatabase : RoomDatabase(){

    abstract fun getAppNoteRoomDao() : AppNoteRoomDao

    companion object {
        @Volatile
        private var database: AppNoteRoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppNoteRoomDatabase{
            return if(database == null) {
                database = Room.databaseBuilder(
                    context,
                    AppNoteRoomDatabase::class.java,
                    "database"
                ).build()
                database as AppNoteRoomDatabase
            } else database as AppNoteRoomDatabase
        }

    }
}