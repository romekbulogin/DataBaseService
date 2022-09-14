package ru.edu.databaseservice.entities

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "Rooms", schema = "public", catalog = "monopoly")
data class RoomsEntity (
    @Id
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(name = "count_of_player", nullable = false)
    var countOfPlayer: Int? = null,

    @Column(name = "mode_game", nullable = false)
    var modeGame: String? = null,

    @Column(name = "type_game", nullable = false)
    var typeGame: String? = null,

    @Column(name = "have_token", nullable = false)
    var haveToken: Boolean? = null,

    @Column(name = "token", nullable = false)
    var token: String? = null,

    @Column(name = "must_regist", nullable = false)
    var mustRegist: Boolean? = null,

    @Column(name = "have_bots", nullable = false)
    var haveBots: Boolean? = null,

    @Column(name = "bots_id", nullable = true, insertable = false, updatable = false)
    var botsId: Int? = null,

    @Column(name = "users_id", nullable = true, insertable = false, updatable = false)
    var usersId: Int? = null,

    @Column(name = "anons_id", nullable = true, insertable = false, updatable = false)
    var anonsId: Int? = null,

    @Column(name = "is_active", nullable = false)
    var isActive: Boolean? = null,

    @Column(name = "date_of_activate", nullable = false)
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
