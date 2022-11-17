package ru.edu.databaseservice.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "anon_users", schema = "public", catalog = "monopoly")
data class AnonUsersEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "iden32")
    var iden32: String? = null,

    @ManyToOne
    @JoinColumn(name="roomsEntity", referencedColumnName = "id")
    var roomsEntity: RoomsEntity? = null,
)
