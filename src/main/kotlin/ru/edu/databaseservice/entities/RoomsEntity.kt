package ru.edu.databaseservice.entities

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "rooms", schema = "public", catalog = "monopoly")
data class RoomsEntity(
    @Id
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(name = "count_of_player", nullable = true)
    var countOfPlayer: Int? = null,

    @Column(name = "mode_game", nullable = true)
    var modeGame: String? = null,

    @Column(name = "type_game", nullable = true)
    var typeGame: String? = null,

    @Column(name = "have_token", nullable = true)
    var haveToken: Boolean? = null,

    @Column(name = "token", nullable = true)
    var token: String? = null,

    @Column(name = "must_regist", nullable = true)
    var mustRegist: Boolean? = null,

    @Column(name = "have_bots", nullable = true)
    var haveBots: Boolean? = null,

    @Column(name = "bots_id", nullable = true, insertable = false, updatable = false)
    var botsId: Int? = null,

    @Column(name = "users_id", nullable = true, insertable = false, updatable = false)
    var usersId: Int? = null,

    @Column(name = "anons_id", nullable = true, insertable = false, updatable = false)
    var anonsId: Int? = null,

    @Column(name = "is_active", nullable = true)
    var isActive: Boolean? = null,

    @Column(name = "date_of_activate", nullable = true)
    var dateOfActivate: Date? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bots_id", referencedColumnName = "id")
    var refBotEntity: BotEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    var refRegUserEntity: RegUserEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anons_id", referencedColumnName = "id")
    var refAnonUserEntity: AnonUserEntity? = null
)
