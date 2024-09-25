package com.kamurashev.graphqlkotlindemoapp.domain.projection

import java.util.UUID
import com.kamurashev.graphqlkotlindemoapp.domain.Title
import com.kamurashev.graphqlkotlindemoapp.domain.Department
import com.kamurashev.graphqlkotlindemoapp.domain.StaffStatus

interface StaffProjection {
    val id: Long
    val firstName: String
    val lastName: String
    val phone: String
    val title: Title
    val department: Department
    val grade: Int
    val status: StaffStatus
    val facility: FacilityProjection
    val guid: UUID
}