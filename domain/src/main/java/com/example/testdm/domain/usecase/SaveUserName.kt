package com.example.testdm.domain.usecase

import com.example.testdm.domain.models.SaveUserNameParam
import com.example.testdm.domain.repository.UserRepository

class SaveUserName(private val userRepository: UserRepository) {
    fun exucute(param: SaveUserNameParam):Boolean{
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName ==  param.name){
            return true
        }
        val result :Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}