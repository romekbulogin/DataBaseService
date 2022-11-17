package ru.edu.databaseservice.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.edu.databaseservice.entities.GameDataOnePlayerEntity

@Repository
interface GameDataOnePlayerRepository : JpaRepository<GameDataOnePlayerEntity, Int> {}
