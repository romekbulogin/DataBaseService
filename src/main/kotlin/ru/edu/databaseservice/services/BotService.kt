package ru.edu.databaseservice.services

import mu.KotlinLogging
import org.springframework.stereotype.Service
import ru.edu.databaseservice.entities.BotEntity
import ru.edu.databaseservice.repositories.BotRepository

private val logger = KotlinLogging.logger { }

@Service
class BotService(private val botRepository: BotRepository) {

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
