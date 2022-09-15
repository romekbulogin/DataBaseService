package ru.edu.databaseservice.entities

import java.util.*
import javax.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "reg_user", schema = "public", catalog = "monopoly")
data class RegUserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null,

    @Column(name = "username", nullable = false)
    var username: String? = null,

    @Column(name = "login", nullable = false)
    var login: String? = null,

    @Column(name = "email", nullable = false)
    var email: String? = null,

    @Column(name = "count_win", nullable = true)
    var countWin: Long? = null,

    @Column(name = "count_lose", nullable = true)
    var countLose: Long? = null,

    @Column(name = "date_of_regist", nullable = true)
    var dateOfRegist: LocalDateTime = LocalDateTime.now(),

    @Column(name = "birthdate", nullable = false)
    var birthdate: Date? = null,

    @OneToMany(mappedBy = "refRegUserEntity")
    var refRatingEntities: List<RatingEntity>? = null,

    @OneToMany(mappedBy = "refRegUserEntity")
    var refRoomsEntities: List<RoomsEntity>? = null
)

