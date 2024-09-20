package com.kamurashev.graphqlkotlindemoapp

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    @Bean
    @ServiceConnection
    fun postgresContainer(): PostgreSQLContainer<*> {
        return PostgreSQLContainer(DockerImageName.parse("postgres:15"))
    }

    @Bean
    @ServiceConnection(name = "openzipkin/zipkin")
    fun zipkinContainer(): GenericContainer<*> {
        return GenericContainer(DockerImageName.parse("openzipkin/zipkin:2.23.16")).withExposedPorts(9411)
    }

}
