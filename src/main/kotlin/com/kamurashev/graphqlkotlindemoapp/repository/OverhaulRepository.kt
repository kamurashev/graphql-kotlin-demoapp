package com.kamurashev.graphqlkotlindemoapp.repository

import com.kamurashev.graphqlkotlindemoapp.domain.entity.OverhaulEntity
import com.kamurashev.graphqlkotlindemoapp.domain.projection.OverhaulProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OverhaulRepository : JpaRepository<OverhaulEntity, Long> {
    @Query("SELECT e FROM OverhaulEntity e")
    fun findAllProjected(): List<OverhaulProjection>
    fun findOverhaulProjectionById(id: Long): OverhaulProjection?
    fun findByEquipmentId(equipmentId: Long): List<OverhaulProjection>
    fun findByGuid(guid: UUID): OverhaulProjection?
}