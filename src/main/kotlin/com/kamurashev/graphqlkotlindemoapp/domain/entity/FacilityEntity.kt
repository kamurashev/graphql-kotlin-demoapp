package com.kamurashev.graphqlkotlindemoapp.domain.entity

import com.kamurashev.graphqlkotlindemoapp.domain.Department
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "facility")
data class FacilityEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val address: String,

    @Enumerated(EnumType.STRING)
    val department: Department,

    @Column(nullable = false, updatable = false)
    val guid: UUID = UUID.randomUUID()
) : AuditableEntity()