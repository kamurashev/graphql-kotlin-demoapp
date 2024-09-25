package com.kamurashev.graphqlkotlindemoapp.domain.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "equipment")
data class EquipmentEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val type: String,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    val facility: FacilityEntity,
    
    @Column(nullable = false, updatable = false)
    val guid: UUID = UUID.randomUUID()
) : AuditableEntity()