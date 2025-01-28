package com.example.testdm.data.storage.sharedPrefs

import android.content.Context
import com.example.testdm.data.storage.UserStorage
import com.example.testdm.data.storage.models.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEYNAME = "ferst name"
private const val KEYLASTNAME = "last name"

class SharedPrefUserStorage(context: Context): UserStorage {
    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    override fun save(user: User):Boolean{
        sharedPreferences.edit().putString(KEYNAME,user.firstName).apply()
        sharedPreferences.edit().putString(KEYLASTNAME,user.lastName).apply()
        return true
    }
    override fun get(): User {
        val firstName = sharedPreferences.getString(KEYNAME,"") ?:""
        val lastName = sharedPreferences.getString(KEYLASTNAME,"")?:""
        return User(firstName = firstName, lastName = lastName)

    }
}