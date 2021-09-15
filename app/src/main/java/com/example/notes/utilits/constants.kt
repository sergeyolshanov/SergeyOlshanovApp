package com.example.notes.utilits

import com.example.notes.sergeyolshanovapp.MainActivity
import com.example.notes.sergeyolshanovapp.module.app_notes.database.DatabaseNoteRepository

var APP_ACTIVITY: MainActivity? = null
var REPOSITORY: DatabaseNoteRepository? = null
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"