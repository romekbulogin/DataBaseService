package ru.edu.databaseservice.services

import mu.KotlinLogging
import org.springframework.stereotype.Service
import ru.edu.databaseservice.entities.AnonUserEntity
import ru.edu.databaseservice.repositories.AnonUserRepository
import ru.edu.databaseservice.response.CreateAnonResponse
import kotlin.math.log

@Service
class AnonUserService(private val anonUserRepository: AnonUserRepository) {
    private val logger = KotlinLogging.logger { }
    fun saveAnonUser(entity: AnonUserEntity): CreateAnonResponse {
        return try {
            logger.info("Request: $entity")
            anonUserRepository.save(entity)
            logger.info("Anon successfully created $entity")
            CreateAnonResponse().apply {
                success = true
                id = entity.id
                iden32 = entity.iden32
            }
        } catch (ex: Exception) {
            logger.error(ex.message)
            CreateAnonResponse().apply {
                success = false
            }
        }
    }

    fun deleteAnonUserById(id: Int) {
        return try {
            logger.info("Request for delete anon user by id=$id")
            anonUserRepository.deleteById(id)
            logger.info("Anon successfully deleted with id=$id")
        } catch (ex: Exception) {
            logger.error(ex.message)
        }
    }

    fun findAnonById(id: Int): AnonUserEntity? {
        return try {
            logger.info("Request for find anon by id=$id")
            val entity = anonUserRepository.findById(id).get()
            logger.info("Anon: $entity")
            entity
        } catch (ex: Exception) {
            logger.error(ex.message)
            null
        }
    }
}
