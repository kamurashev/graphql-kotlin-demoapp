package com.kamurashev.graphqlkotlindemoapp.domain.projection

import java.util.UUID

interface EquipmentProjection {
    val id: Long
    val name: String
    val type: String
    val facility: FacilityProjection
    val guid: UUID
}