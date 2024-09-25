package com.kamurashev.graphqlkotlindemoapp.repository

import com.kamurashev.graphqlkotlindemoapp.domain.entity.FacilityEntity
import com.kamurashev.graphqlkotlindemoapp.domain.Department
import com.kamurashev.graphqlkotlindemoapp.domain.projection.FacilityProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface FacilityRepository : JpaRepository<FacilityEntity, Long> {
    @Query("SELECT e.id AS id, e.name AS name, e.address AS address, e.department AS department, e.guid AS guid FROM FacilityEntity e")
    fun findAllProjected(): List<FacilityProjection>
    fun findFacilityProjectionById(id: Long): FacilityProjection?
    fun findByDepartment(department: Department): List<FacilityProjection>
    fun findByGuid(guid: UUID): FacilityProjection?
}