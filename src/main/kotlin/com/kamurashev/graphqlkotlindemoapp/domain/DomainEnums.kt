package com.kamurashev.graphqlkotlindemoapp.domain

enum class Department {
    MINING,
    POWER_GENERATION,
    MAINTENANCE,
    ADMINISTRATION,
    LOGISTICS,
    SAFETY
}

enum class Title {
    MANAGER,
    SUPERVISOR,
    TECHNICIAN,
    ENGINEER,
    OPERATOR,
    ADMINISTRATOR
}

enum class OverhaulStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED,
    CANCELED
}

enum class StaffStatus {
    ACTIVE,
    INACTIVE
}