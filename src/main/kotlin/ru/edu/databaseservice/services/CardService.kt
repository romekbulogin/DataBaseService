package ru.edu.databaseservice.services

import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import ru.edu.databaseservice.entities.CardEntity
import ru.edu.databaseservice.repositories.CardRepository

@Service
class CardService(private val cardRepository: CardRepository) {
    private val logger = KotlinLogging.logger { }

    fun saveCard(cardEntity: CardEntity) {
        try {
            logger.info("Save $cardEntity")
            cardRepository.save(cardEntity)
        } catch (ex: Exception) {
            logger.error(ex.message)
        }
    }

    fun findById(id: Int) = cardRepository.findById(id).get()

    fun findAll(): MutableList<CardEntity> = cardRepository.findAll()
}
