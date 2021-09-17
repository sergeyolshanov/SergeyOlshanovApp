package com.example.notes.utilits

import com.example.notes.sergeyolshanovapp.MainActivity
import com.example.notes.sergeyolshanovapp.module.app_notes.database.DatabaseNoteRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

var APP_ACTIVITY : MainActivity? = null
var REPOSITORY : DatabaseNoteRepository? = null
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
var EMAIL : String? = null
var PASSWORD : String? = null
const val ID_FIREBASE = "idFirebase"
const val NAME = "name"
const val TEXT = "text"
var AUTH: FirebaseAuth? = null
var CURRENT_ID: String? = null
var REF_DATABASE: DatabaseReference? = null