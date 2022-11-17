package ru.edu.databaseservice.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "rating", schema = "public", catalog = "monopoly")
data class RatingEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "id_user")
    @OneToMany(mappedBy = "ratingEntity")
    var idUser: MutableList<RegUserEntity>? = mutableListOf(),

    @Column(name = "date_add")
    var dateAdd: Date? = null
)
