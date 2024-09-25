package com.kamurashev.graphqlkotlindemoapp.resolver

import com.kamurashev.graphqlkotlindemoapp.domain.projection.StaffProjection
import com.kamurashev.graphqlkotlindemoapp.repository.StaffRepository
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class StaffResolver(private val staffRepository: StaffRepository) {
    @QueryMapping
    fun staffs(): List<StaffProjection> = staffRepository.findAllProjected()

    @QueryMapping
    fun staffById(id: Long): StaffProjection? = staffRepository.findStaffProjectionById(id)
}