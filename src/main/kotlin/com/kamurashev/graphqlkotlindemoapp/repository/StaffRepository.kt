package com.kamurashev.graphqlkotlindemoapp.repository

import com.kamurashev.graphqlkotlindemoapp.domain.entity.StaffEntity
import com.kamurashev.graphqlkotlindemoapp.domain.projection.StaffProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StaffRepository : JpaRepository<StaffEntity, Long> {
    @Query("SELECT e FROM StaffEntity e")
    fun findAllProjected(): List<StaffProjection>
    fun findStaffProjectionById(id: Long): StaffProjection?
}