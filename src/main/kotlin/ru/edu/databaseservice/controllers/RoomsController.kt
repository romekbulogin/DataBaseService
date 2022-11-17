package ru.edu.databaseservice.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import ru.edu.databaseservice.entities.RoomsEntity
import ru.edu.databaseservice.services.RoomsService

@Controller
@RequestMapping("/api/rooms")
class RoomsController(private val roomsService: RoomsService) {
    @PostMapping("/new")
    @ResponseBody
    fun save(@RequestParam roomsEntity: RoomsEntity) = roomsService.save(roomsEntity)

    @GetMapping("/get")
    @ResponseBody
    fun findById(@RequestParam id: Int) = roomsService.findRoomById(id)

    @GetMapping("/get_by_token")
    @ResponseBody
    fun findByToken(@RequestParam token: String) = roomsService.findRoomByToken(token)
}
