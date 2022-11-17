package ru.edu.databaseservice.controllers

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.edu.databaseservice.entities.AnonUsersEntity
import ru.edu.databaseservice.services.AnonUserService

@RestController
@RequestMapping("/api/anon")
class AnonsController(
    private val anonUserService: AnonUserService
) {
    private val logger = KotlinLogging.logger { }

    @PostMapping("/create")
    fun save(@RequestBody entity: AnonUsersEntity) = anonUserService.saveAnonUser(entity)

    @PostMapping("/delete")
    fun deleteAnonUserById(@RequestParam("id") id: Int) = anonUserService.deleteAnonUserById(id)

    @GetMapping("/find")
    fun findAnonUserById(@RequestParam("id") id: Int) = anonUserService.findAnonById(id)
}
