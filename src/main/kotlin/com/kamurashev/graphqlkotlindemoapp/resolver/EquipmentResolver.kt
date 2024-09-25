package com.kamurashev.graphqlkotlindemoapp.resolver

import com.kamurashev.graphqlkotlindemoapp.domain.projection.EquipmentProjection
import com.kamurashev.graphqlkotlindemoapp.repository.EquipmentRepository
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class EquipmentResolver(private val equipmentRepository: EquipmentRepository) {
    @QueryMapping
    fun equipments(): List<EquipmentProjection> = equipmentRepository.findAllProjected()

    @QueryMapping
    fun equipmentById(id: Long): EquipmentProjection? = equipmentRepository.findEquipmentProjectionById(id)
}