package ru.edu.databaseservice.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.edu.databaseservice.entities.RatingEntity
import ru.edu.databaseservice.entities.RegUserEntity

@Repository
interface RatingRepository : JpaRepository<RatingEntity, Int> {}
