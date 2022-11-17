package ru.edu.databaseservice.services

import mu.KotlinLogging
import org.springframework.stereotype.Service
import ru.edu.databaseservice.entities.RealEstateEntity
import ru.edu.databaseservice.repositories.RealEstateRepository

@Service
class RealEstateService(private val realEstateRepository: RealEstateRepository) {

    private val logger = KotlinLogging.logger { }

    fun saveRealEstate(realEstate: RealEstateEntity) {
        try {
            logger.info("Save $realEstate")
            realEstateRepository.save(realEstate)
        } catch (ex: Exception) {
            logger.error(ex.message)
        }
    }

    fun findById(id: Int) = realEstateRepository.findById(id).get()

    fun findAll(): MutableList<RealEstateEntity> = realEstateRepository.findAll()
}
