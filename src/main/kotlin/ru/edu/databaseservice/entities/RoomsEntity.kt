package ru.edu.databaseservice.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "rooms", schema = "public", catalog = "monopoly")
data class RoomsEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "count_of_player")
    var countOfPlayer: Int? = null,

    @Column(name = "mode_game")
    var modeGame: String? = null,

    @Column(name = "type_game")
    var typeGame: String? = null,

    @Column(name = "have_token")
    var haveToken: Boolean? = null,

    @Column(name = "token")
    var token: String? = null,

    @Column(name = "must_regist")
    var mustRegist: Boolean? = null,

    @Column(name = "have_bots")
    var haveBots: Boolean? = null,

    @Column(name = "bots_id")
    @OneToMany(targetEntity = BotEntity::class, mappedBy = "roomsEntity")
    var botsId: MutableList<BotEntity>? = mutableListOf(),

    @Column(name = "users_id")
    @OneToMany(targetEntity = RegUserEntity::class, mappedBy = "roomsEntity")
    var usersId: MutableList<RegUserEntity>? = mutableListOf(),

    @Column(name = "anons_id")
    @OneToMany(targetEntity = AnonUsersEntity::class, mappedBy = "roomsEntity")
    var anonsId: MutableList<AnonUsersEntity>? = mutableListOf(),

    @Column(name = "is_active")
    var isActive: Boolean? = null,

    @Column(name = "date_activate")
    var dateActivate: Date? = null
)
