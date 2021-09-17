package com.example.notes.utilits

import com.example.notes.sergeyolshanovapp.MainActivity
import com.example.notes.sergeyolshanovapp.module.app_notes.database.DatabaseNoteRepository

var APP_ACTIVITY: MainActivity? = null
var REPOSITORY: DatabaseNoteRepository? = null
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
var EMAIL : String? = null
var PASSWORD : String? = null
const val ID_FIREBASE = "id_firebase"
const val NAME = "name"
const val TEXT = "text"