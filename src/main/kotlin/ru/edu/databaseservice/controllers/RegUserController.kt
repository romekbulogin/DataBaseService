package ru.edu.databaseservice.controllers

import mu.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import ru.edu.databaseservice.entities.RegUserEntity
import ru.edu.databaseservice.repositories.RegUserRepository
import ru.edu.databaseservice.response.CreateUser


@Controller
@RequestMapping("/api/reg_user")
class RegUserController(
    private val regUserRepository: RegUserRepository
) {

    private val logger = KotlinLogging.logger { }

    @PostMapping("/create")
    @ResponseBody
    fun createRegUser(@RequestBody regUserEntity: RegUserEntity): CreateUser {
        return try {
            logger.info("Create new user: $regUserEntity")
            regUserRepository.save(regUserEntity)
            CreateUser().apply {
                success = true
                userId = regUserEntity.id
                userName = regUserEntity.username
                dateCreate = regUserEntity.dateOfRegist
            }
        } catch (ex: Exception) {
            logger.error("User not create${ex.message}")
            CreateUser().apply {
                success = false
            }
        }
    }

    @GetMapping("/get")
    @ResponseBody
    fun findGetUser(@RequestParam("id") id: Int): RegUserEntity? {
        return try {
            val entity = regUserRepository.findById(id).get()
            logger.info("Response by database: $entity")
            return entity
        } catch (ex: Exception) {
            logger.error { ex.message }
            null
        }
    }
}
