package ru.edu.databaseservice.services

import mu.KotlinLogging
import org.springframework.stereotype.Service
import ru.edu.databaseservice.entities.BotEntity
import ru.edu.databaseservice.repositories.BotRepository

@Service
class BotService(private val botRepository: BotRepository) {

    private val logger = KotlinLogging.logger { }

    fun findById(id: Int) = botRepository.findById(id)?.get()
    fun saveBot(bot: BotEntity) {
        try {
            logger.info("Bot ${bot.token} created")
            botRepository.save(bot)
        } catch (ex: Exception) {
            logger.error("Error: bot ${bot.token} not created")
        }
    }

    fun deleteBotById(id: Int) {
        try {
            logger.info("Bot $id deleted")
            botRepository.deleteById(id)
        } catch (ex: Exception) {
            logger.error("Error: bot $id not deleted")
        }
    }
}
