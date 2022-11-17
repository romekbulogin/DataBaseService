package ru.edu.databaseservice.services

import mu.KotlinLogging
import org.springframework.stereotype.Service
import ru.edu.databaseservice.entities.RoomsEntity
import ru.edu.databaseservice.repositories.RoomsRepository

@Service
class RoomsService(private val roomsRepository: RoomsRepository) {

    private val logger = KotlinLogging.logger { }
    fun findRoomByToken(token: String) = roomsRepository.findRoomsEntityByToken(token)
    fun findRoomById(id: Int) = roomsRepository.findById(id).get()

    fun save(room: RoomsEntity) {
        try {
            logger.info("Save $room")
            roomsRepository.save(room)
        } catch (ex: Exception) {
            logger.info(ex.message)
        }
    }
}
