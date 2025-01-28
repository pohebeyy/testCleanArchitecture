package com.example.testdm.domain.usecase

import com.example.testdm.domain.models.UserName
import com.example.testdm.domain.repository.UserRepository

class GetUserName(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()

    }
}