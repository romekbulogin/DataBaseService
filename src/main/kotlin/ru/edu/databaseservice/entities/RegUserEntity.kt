package ru.edu.databaseservice.entities

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "Reg_User", schema = "public", catalog = "monopoly")
data class RegUserEntity(
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null,

    @Column(name = "username", nullable = false)
    var username: String? = null,

    @Column(name = "login", nullable = false)
    var login: String? = null,

    @Column(name = "email", nullable = false)
    var email: String? = null,

    @Column(name = "count_win", nullable = false)
    var countWin: Int? = null,

    @Column(name = "count_lose", nullable = false)
    var countLose: Int? = null,

    @Column(name = "date_of_regist", nullable = false)
    var dateOfRegist: Date? = null,

    @Column(name = "birthdate", nullable = false)
    var birthdate: Date? = null,

    @OneToMany(mappedBy = "refRegUserEntity")
    var refRatingEntities: List<RatingEntity>? = null,

    @OneToMany(mappedBy = "refRegUserEntity")
    var refRoomsEntities: List<RoomsEntity>? = null

)

