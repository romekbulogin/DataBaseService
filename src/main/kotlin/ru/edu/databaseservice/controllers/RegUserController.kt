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
import ru.edu.databaseservice.response.CreateUserResponse
import ru.edu.databaseservice.services.RegUserService


@Controller
@RequestMapping("/api/reg_user")
class RegUserController(
    private val regUserService: RegUserService
) {

    private val logger = KotlinLogging.logger { }

    @PostMapping("/new")
    @ResponseBody
    fun createRegUser(@RequestBody regUserEntity: RegUserEntity): CreateUserResponse {
        return try {
            logger.info("Save: $regUserEntity")
            regUserService.save(regUserEntity)
            CreateUserResponse().apply {
                success = true
                userId = regUserEntity.id
                userName = regUserEntity.username
                dateCreate = regUserEntity.dateOfRegist
            }
        } catch (ex: Exception) {
            logger.error("User not create${ex.message}")
            CreateUserResponse().apply {
                success = false
            }
        }
    }

    @GetMapping("/get")
    @ResponseBody
    fun findUserById(@RequestParam("id") id: Int): RegUserEntity? {
        return try {
            val entity = regUserService.findUserById(id)
            logger.info("Response by database: $entity")
            entity
        } catch (ex: Exception) {
            logger.error { ex.message }
            null
        }
    }

    @GetMapping("/get_by_username")
    @ResponseBody
    fun findUserByUserName(@RequestParam("username") userName: String): RegUserEntity? {
        return try {
            val entity = regUserService.findUserByUserName(userName)
            logger.info("Response by database: $entity")
            entity
        } catch (ex: Exception) {
            logger.error { ex.message }
            null
        }
    }
}
