package com.kamurashev.graphqlkotlindemoapp.repository

import com.kamurashev.graphqlkotlindemoapp.domain.entity.EquipmentEntity
import com.kamurashev.graphqlkotlindemoapp.domain.projection.EquipmentProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface EquipmentRepository : JpaRepository<EquipmentEntity, Long> {
    @Query("SELECT e FROM EquipmentEntity e")
    fun findAllProjected(): List<EquipmentProjection>
    fun findEquipmentProjectionById(id: Long): EquipmentProjection?
    fun findByFacilityId(facilityId: Long): List<EquipmentProjection>
    fun findByGuid(guid: UUID): EquipmentProjection?
}