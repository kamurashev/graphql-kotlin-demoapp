package com.kamurashev.graphqlkotlindemoapp.domain.entity

import com.kamurashev.graphqlkotlindemoapp.domain.OverhaulStatus
import jakarta.persistence.*
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "overhaul")
data class OverhaulEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val description: String,
    val date: LocalDate,

    @Enumerated(EnumType.STRING)
    val status: OverhaulStatus,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    val equipment: EquipmentEntity,

    @Column(nullable = false, updatable = false)
    val guid: UUID = UUID.randomUUID()
) : AuditableEntity()