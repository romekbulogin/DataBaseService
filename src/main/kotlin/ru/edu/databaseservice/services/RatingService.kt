package ru.edu.databaseservice.services

import mu.KotlinLogging
import org.springframework.stereotype.Service
import ru.edu.databaseservice.repositories.RatingRepository

@Service
class RatingService(private val ratingRepository: RatingRepository) {
    private val logger = KotlinLogging.logger { }

}
