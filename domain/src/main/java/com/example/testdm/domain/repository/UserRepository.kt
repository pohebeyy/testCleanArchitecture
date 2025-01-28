package com.example.testdm.domain.repository

import com.example.testdm.domain.models.SaveUserNameParam
import com.example.testdm.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam):Boolean

    fun getName(): UserName
}