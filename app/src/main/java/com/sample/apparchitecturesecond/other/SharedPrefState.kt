package com.sample.apparchitecturesecond.other

import android.content.Context

object SharedPrefState {

    fun saveStringPrefes(key: String?, value: String?, context: Context) {
        val sharedPreferences = context.getSharedPreferences("SharedPreferance", Context.MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()
        myEdit.putString(key, value)
        myEdit.apply()
    }

    fun getStringPrefes(key: String?, context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("SharedPreferance", Context.MODE_PRIVATE)
        return sharedPreferences.getString(
            key, ""
        )
    }
}