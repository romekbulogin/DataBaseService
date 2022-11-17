package ru.edu.databaseservice.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "game_data_one_player", schema = "public", catalog = "monopoly")
data class GameDataOnePlayerEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "id_player")
    var idPlayer: Int? = null,

    @Column(name = "type_of_player")
    var typeOfPlayer: String? = null,

    @Column(name = "position_on_field")
    var positionOnField: String? = null,

    @Column(name = "count_of_queue")
    var countOfQueue: Int? = null,

    @Column(name = "type_of_figure")
    var typeOfFigure: String? = null,

    @Column(name = "count_of_money")
    var countOfMoney: Int? = null,

    @Column(name = "cards")
    @OneToMany(mappedBy = "gameDataOnePlayerEntity", fetch = FetchType.LAZY)
    var cards: MutableList<CardEntity>? = null,

    @Column(name = "real_estate")
    @OneToMany(mappedBy = "gameDataOnePlayerEntity",fetch = FetchType.LAZY)
    var realEstate: MutableList<RealEstateEntity>? = null

)
