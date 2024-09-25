package com.kamurashev.graphqlkotlindemoapp.resolver

import com.kamurashev.graphqlkotlindemoapp.domain.projection.FacilityProjection
import com.kamurashev.graphqlkotlindemoapp.repository.FacilityRepository
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class FacilityResolver(private val facilityRepository: FacilityRepository) {
    @QueryMapping
    fun facilities(): List<FacilityProjection> = facilityRepository.findAllProjected()

    @QueryMapping
    fun facilityById(id: Long): FacilityProjection? = facilityRepository.findFacilityProjectionById(id)
}