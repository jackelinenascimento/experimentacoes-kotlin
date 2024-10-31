package org.example.adapter.rest.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.example.domain.model.Person
import java.util.UUID

data class PersonRequestDTO(
    @NotBlank
    val name: String,

    @NotNull
    val age: Int
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
            person.id,
            person.name,
            person.age,
            person.creationDate
        )
    }
}
