package ru.edu.databaseservice.services

import org.springframework.stereotype.Service
import ru.edu.databaseservice.repositories.RoomsRepository

@Service
class RoomsService(private val roomsRepository: RoomsRepository) {

    fun findRoomById(id: Int) = roomsRepository.findById(id).get()
}
