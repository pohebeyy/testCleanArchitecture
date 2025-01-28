package com.example.testdm.data.repository

import com.example.testdm.data.storage.models.User
import com.example.testdm.data.storage.UserStorage
import com.example.testdm.domain.models.SaveUserNameParam
import com.example.testdm.domain.models.UserName
import com.example.testdm.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEYNAME = "ferst name"
private const val KEYLASTNAME = "last name"
class UserRepositoryImp(private val userStorage: UserStorage): UserRepository {


    override fun saveName(saveParam:SaveUserNameParam):Boolean{
        val user = mapToStorage(saveParam)
        val result = userStorage.save(user)
        return result
    }
    private fun mapToStorage(saveParam:SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }
    override fun getName():UserName{
        val user = userStorage.get()

        return mapToDomian(user)
    }
    private fun mapToDomian(user: User):UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}