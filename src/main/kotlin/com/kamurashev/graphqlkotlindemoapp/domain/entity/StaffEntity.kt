package com.kamurashev.graphqlkotlindemoapp.domain.entity

import com.kamurashev.graphqlkotlindemoapp.domain.Department
import com.kamurashev.graphqlkotlindemoapp.domain.Title
import com.kamurashev.graphqlkotlindemoapp.domain.StaffStatus
import jakarta.persistence.*
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import java.util.UUID

@Entity
@Table(name = "staff")
data class StaffEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    val phone: String,
    @Enumerated(EnumType.STRING)
    val title: Title,
    @Enumerated(EnumType.STRING)
    val department: Department,
    @Min(1)
    @Max(7)
    val grade: Int,
    @Enumerated(EnumType.STRING)
    val status: StaffStatus,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    val facility: FacilityEntity,
    @Column(nullable = false, updatable = false)
    val guid: UUID = UUID.randomUUID()
) : AuditableEntity()