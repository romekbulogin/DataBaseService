package ru.edu.databaseservice.entities

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "Bot", schema = "public", catalog = "monopoly")
data class BotEntity(
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null,

    @Column(name = "token", nullable = false)
    var token: String? = null,

    @Column(name = "date_begin_work", nullable = true)
    var dateBeginWork: Date? = null,

    @Column(name = "count_of_use", nullable = true)
    var countOfUse: Int? = null,

    @Column(name = "is_free", nullable = true)
    var isFree: Boolean? = null,

    @OneToMany(mappedBy = "refBotEntity")
    var refRoomsEntities: List<RoomsEntity>? = null
)
