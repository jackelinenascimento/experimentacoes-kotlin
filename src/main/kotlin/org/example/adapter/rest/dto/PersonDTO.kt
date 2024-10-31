package org.example.adapter.rest.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import org.example.domain.model.Person
import java.util.UUID

data class PersonRequestDTO(
    @field:NotBlank(message = "Name is required")val name: String,
    @field:Positive(message = "Age must be positve") val age: Int
) {
    fun toDomain() = Person(name = name, age = age)
}

data class PersonResponseDTO(
    val id: UUID,
    val name: String,
    val age: Int,
    val creationDate: String
) {
    companion object {
        fun fromDomain(person: Person) = PersonResponseDTO(
            person.id ?: UUID.randomUUID(),
            person.name,
            person.age,
            person.creationDate ?: ""
        )
    }
}
