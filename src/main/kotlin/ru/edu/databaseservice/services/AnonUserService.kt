package ru.edu.databaseservice.services

import mu.KotlinLogging
import org.springframework.stereotype.Service
import ru.edu.databaseservice.entities.AnonUserEntity
import ru.edu.databaseservice.repositories.AnonUserRepository

private val logger = KotlinLogging.logger { }

@Service
class AnonUserService(private val anonUserRepository: AnonUserRepository) {

    fun saveAnonUser(anonUser: AnonUserEntity) {
        try {
            logger.info("Anon user $anonUser created")
            anonUserRepository.save(anonUser)
        } catch (ex: Exception) {
            logger.error("Anon user $anonUser not created")
        }
    }

    fun deleteAnonUserById(id: Int) {
        try {
            logger.info("Anon user with id=$id deleted")
            anonUserRepository.deleteById(id)
        } catch (ex: Exception) {
            logger.error("Anon user with id=$id not deleted")
        }
    }
}
