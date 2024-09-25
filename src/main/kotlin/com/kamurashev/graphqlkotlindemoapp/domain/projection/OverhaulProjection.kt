package com.kamurashev.graphqlkotlindemoapp.domain.projection

import java.time.LocalDate
import java.util.UUID
import com.kamurashev.graphqlkotlindemoapp.domain.OverhaulStatus

interface OverhaulProjection {
    val id: Long
    val description: String
    val date: LocalDate
    val status: OverhaulStatus
    val equipment: EquipmentProjection
    val guid: UUID
}