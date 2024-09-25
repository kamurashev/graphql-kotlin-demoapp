package com.kamurashev.graphqlkotlindemoapp.domain.projection

import com.kamurashev.graphqlkotlindemoapp.domain.Department
import java.util.UUID

interface FacilityProjection {
    val id: Long
    val name: String
    val address: String
    val department: Department
    val guid: UUID
}