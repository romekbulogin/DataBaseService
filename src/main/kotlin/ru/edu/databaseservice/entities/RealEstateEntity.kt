package ru.edu.databaseservice.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "real_estate", schema = "public", catalog = "monopoly")
data class RealEstateEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "street")
    var street: String? = null,

    @Column(name = "title")
    var title: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gameDataOnePlayerEntity")
    var gameDataOnePlayerEntity: GameDataOnePlayerEntity? = null,
)
