package ru.edu.databaseservice.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reg_user", schema = "public", catalog = "monopoly")
data class RegUserEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "username")
    var username: String? = null,

    @Column(name = "login")
    var login: String? = null,

    @Column(name = "password")
    var password: String? = null,

    @Column(name = "email")
    var email: String? = null,

    @Column(name = "count_win")
    var countWin: Long? = null,

    @Column(name = "count_lose")
    var countLose: Long? = null,

    @Column(name = "date_of_regist")
    var dateOfRegist: Date? = null,

    @Column(name = "birthdate")
    var birthdate: Date? = null,

    @ManyToOne
    @JoinColumn(name = "roomsEntity")
    var roomsEntity: RoomsEntity? = null,

    @ManyToOne
    @JoinColumn(name = "ratingEntity")
    var ratingEntity: RatingEntity? = null,
)
