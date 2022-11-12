package ru.edu.databaseservice.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import ru.edu.databaseservice.entities.BotEntity
import ru.edu.databaseservice.services.BotService

@Controller
@RequestMapping("/api/bot")
class BotController(private val botService: BotService) {

    @GetMapping("/get")
    @ResponseBody
    fun findById(@RequestParam id: Int) = botService.findById(id)

    @PostMapping("/new")
    @ResponseBody
    fun save(@RequestParam botEntity: BotEntity) = botService.saveBot(botEntity)

    @PostMapping("/delete")
    @ResponseBody
    fun delete(@RequestParam id: Int) = botService.deleteBotById(id)
}
