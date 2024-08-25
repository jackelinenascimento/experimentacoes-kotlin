package org.example.adapter.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.example.domain.model.Person
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "person")
data class PersonEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val age: Int,
    val creationDate: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this(UUID.randomUUID(), "", 0)

    fun toDomain(): Person = Person(id, name, age, creationDate.toString())

    companion object {
        fun fromDomain(person: Person): PersonEntity =
            PersonEntity(person.id, person.name, person.age)
    }
}
