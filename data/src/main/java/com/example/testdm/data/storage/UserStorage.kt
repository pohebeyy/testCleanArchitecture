package com.example.testdm.data.storage

import com.example.testdm.data.storage.models.User

interface UserStorage {
    fun save(user: User):Boolean
    fun get(): User
}