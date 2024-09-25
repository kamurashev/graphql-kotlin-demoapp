package com.kamurashev.graphqlkotlindemoapp.resolver

import com.kamurashev.graphqlkotlindemoapp.domain.projection.OverhaulProjection
import com.kamurashev.graphqlkotlindemoapp.repository.OverhaulRepository
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class OverhaulResolver(private val overhaulRepository: OverhaulRepository) {
    @QueryMapping
    fun overhauls(): List<OverhaulProjection> = overhaulRepository.findAllProjected()

    @QueryMapping
    fun overhaulById(id: Long): OverhaulProjection? = overhaulRepository.findOverhaulProjectionById(id)
}