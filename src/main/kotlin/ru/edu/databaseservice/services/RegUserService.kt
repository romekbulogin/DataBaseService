package ru.edu.databaseservice.services

import mu.KotlinLogging
import org.springframework.stereotype.Service
import ru.edu.databaseservice.entities.RegUserEntity
import ru.edu.databaseservice.repositories.RegUserRepository
import kotlin.math.log

@Service
class RegUserService(private val regUserRepository: RegUserRepository) {

    private val logger = KotlinLogging.logger { }
    fun findUserById(id: Int) = regUserRepository.findById(id).get()
    fun findUserByUserName(userName: String) = regUserRepository.findByUsernameContainsIgnoreCase(userName)

    fun save(entity: RegUserEntity) {
        try {
            logger.info("Save $entity")
            regUserRepository.save(entity)
        } catch (ex: Exception) {
            logger.info(ex.message)
        }
    }
}
