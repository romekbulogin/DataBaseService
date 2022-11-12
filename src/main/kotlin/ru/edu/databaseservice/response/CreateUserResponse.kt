package ru.edu.databaseservice.response

import org.springframework.web.bind.annotation.ResponseBody
import java.time.LocalDateTime

@ResponseBody
class CreateUserResponse {
    var success: Boolean? = null
    var userId: Int? = null
    var userName: String? = null
    var dateCreate: LocalDateTime? = null
}
