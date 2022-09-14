package ru.edu.databaseservice.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.edu.databaseservice.entities.RegUserEntity

@Repository
interface RegUserRepository : JpaRepository<RegUserEntity, Int> {
    fun findByUsernameContainsIgnoreCase(userName: String): RegUserEntity?
    fun findByEmailContainsIgnoreCase(email: String): RegUserEntity?
}
