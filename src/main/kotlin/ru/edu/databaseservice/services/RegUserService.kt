package ru.edu.databaseservice.services

import org.springframework.stereotype.Service
import ru.edu.databaseservice.repositories.RegUserRepository

@Service
class RegUserService(private val regUserRepository: RegUserRepository) {

    fun findUserById(id: Int) = regUserRepository.findById(id).get()
    fun findUserByUserName(userName: String) = regUserRepository.findByUsernameContainsIgnoreCase(userName)
}
