package com.example.notes.utilits

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {

    private const val INIT_USER = "initUser"
    private const val TYPE_DB = "typeDB"
    private const val NAME_PREF = "preference"

    var mSharedPreferences: SharedPreferences? = null

    fun getPreference(context: Context) : SharedPreferences {
        mSharedPreferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
        return mSharedPreferences!!
    }

    fun setInitUser(init: Boolean) {
        mSharedPreferences?.edit()
            ?.putBoolean(INIT_USER, init)
            ?.apply()
    }

    fun setTypeDB(type: String) {
        mSharedPreferences?.edit()
            ?.putString(TYPE_DB, type)
            ?.apply()

    }

    fun getInitUser() : Boolean {
        return mSharedPreferences?.getBoolean(INIT_USER, false)!!
    }

    fun getTypeDB(): String {
        return mSharedPreferences?.getString(TYPE_DB, TYPE_ROOM)!!
    }
}