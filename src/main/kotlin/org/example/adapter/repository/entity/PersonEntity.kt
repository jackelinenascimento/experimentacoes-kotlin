package org.example.adapter.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import org.example.domain.model.Person
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "person")
data class PersonEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID = UUID.randomUUID(),

    @field:NotBlank(message = "Name is mandatory")
    val name: String,

    @field:Positive(message = "Age must be positive")
    val age: Int,

    val creationDate: LocalDateTime = LocalDateTime.now()
) {
    protected constructor() : this(UUID.randomUUID(), "", 0, LocalDateTime.now())

    fun toDomain(): Person = Person(id, name, age, creationDate.toString())

    companion object {
        fun fromDomain(person: Person): PersonEntity =
            PersonEntity(person.id ?: UUID.randomUUID(), person.name, person.age)
    }
}
