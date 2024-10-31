package org.example.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class Person(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val age: Int,
    val creationDate: String = LocalDateTime.now().toString()
)
