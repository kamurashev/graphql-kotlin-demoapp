package com.kamurashev.graphqlkotlindemoapp.domain.entity

import java.time.LocalDateTime
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Column
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate

@MappedSuperclass
abstract class AuditableEntity {
    @Column(nullable = false, updatable = false)
    lateinit var createdDate: LocalDateTime

    @Column(nullable = false)
    lateinit var updatedDate: LocalDateTime

    var createdBy: Long? = null
    var updatedBy: Long? = null

    @PrePersist
    protected fun onCreate() {
        createdDate = LocalDateTime.now()
        updatedDate = LocalDateTime.now()
    }

    @PreUpdate
    protected fun onUpdate() {
        updatedDate = LocalDateTime.now()
    }
}