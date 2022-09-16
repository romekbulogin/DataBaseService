package ru.edu.databaseservice.entities

import javax.persistence.*

@Entity
@Table(name = "anon_user", schema = "public", catalog = "monopoly")
data class AnonUserEntity (
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null,

    @Column(name = "iden32", nullable = false)
    var iden32: String? = null,

    @OneToMany(mappedBy = "refAnonUserEntity")
    var refRoomsEntities: List<RoomsEntity>? = null
)

