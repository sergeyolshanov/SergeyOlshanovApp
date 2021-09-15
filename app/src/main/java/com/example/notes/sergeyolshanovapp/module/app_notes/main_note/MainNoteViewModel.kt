package com.example.notes.sergeyolshanovapp.module.app_notes.main_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notes.utilits.REPOSITORY

class MainNoteViewModel(application: Application): AndroidViewModel(application) {
    val allNotes = REPOSITORY?.allNotes
}