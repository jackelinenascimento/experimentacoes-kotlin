package org.example.adapter.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.example.domain.model.Person
import java.util.UUID

@Entity
data class PersonEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val age: Int
) {
    constructor() : this(UUID.randomUUID(), "", 0)

    fun toDomain(): Person = Person(id, name, age)

    companion object {
        fun fromDomain(person: Person): PersonEntity =
            PersonEntity(person.id, person.name, person.age)
    }
}
