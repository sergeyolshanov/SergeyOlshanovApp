package com.example.notes.sergeyolshanovapp.module.app_notes.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.sergeyolshanovapp.module.app_notes.model.AppNote
import com.example.notes.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNewNoteViewModel(application: Application) : AndroidViewModel(application) {

    /** Добавляем заметку в базу */
    fun insert(note: AppNote, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY?.insert(note) {
                launch{
                    withContext(Dispatchers.Main) {
                        onSuccess()
                    }
                }
            }
        }
}