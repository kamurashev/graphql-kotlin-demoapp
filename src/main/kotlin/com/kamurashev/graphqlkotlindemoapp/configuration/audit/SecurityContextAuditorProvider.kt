package com.kamurashev.graphqlkotlindemoapp.configuration.audit

import org.springframework.data.domain.AuditorAware
import java.util.*

class SecurityContextAwareAuditorProvider : AuditorAware<Long> {
    companion object {
        const val DEFAULT_AUDITOR_ID: Long = 1000L
    }
    override fun getCurrentAuditor(): Optional<Long> {
//        val authentication = SecurityContextHolder.getContext().authentication
//        return if (authentication != null && authentication.isAuthenticated) {
//            val principal = authentication.principal
//            // Assuming your Principal has a method `getUuid()` that returns a UUID or a property `uuid`
//            (principal as? YourPrincipalClass)?.uuid
//        } else {
//            null
//        }
        return Optional.of(DEFAULT_AUDITOR_ID);
    }
}
