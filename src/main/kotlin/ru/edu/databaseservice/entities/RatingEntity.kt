package ru.edu.databaseservice.entities

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "Rating", schema = "public", catalog = "monopoly")
data class RatingEntity (
    @Id
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(name = "id_user", nullable = true, insertable = false, updatable = false)
    var idUser: Int? = null,

    @Column(name = "date_add", nullable = true)
    var dateAdd: Date? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    var refRegUserEntity: RegUserEntity? = null
)

