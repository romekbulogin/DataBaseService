package ru.edu.databaseservice.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "bot", schema = "public", catalog = "monopoly")
data class BotEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "token")
    var token: String? = null,

    @Column(name = "date_begin_work")
    var dateBeginWork: Date? = null,

    @Column(name = "count_of_use")
    var countOfUse: Int? = null,

    @Column(name = "is_free")
    var isFree: Boolean? = null,

    @ManyToOne
    @JoinColumn(name = "roomsEntity")
    var roomsEntity: RoomsEntity? = null,
)
