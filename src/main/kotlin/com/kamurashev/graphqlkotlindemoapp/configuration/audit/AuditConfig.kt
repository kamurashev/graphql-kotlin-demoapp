package com.kamurashev.graphqlkotlindemoapp.configuration.audit

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
class AuditConfig {
    @Bean fun auditorProvider() = SecurityContextAwareAuditorProvider()
}