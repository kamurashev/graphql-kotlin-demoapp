package com.kamurashev.graphqlkotlindemoapp

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<GraphqlKotlinDemoappApplication>().with(TestcontainersConfiguration::class).run(*args)
}