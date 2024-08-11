package org.example.domain.repository

import org.example.domain.model.Person
import java.util.UUID

interface PersonRepository {
    fun save(person: Person)
    fun findById(id: UUID): Person?
    fun findAll(): List<Person>
    fun deleteById(id: UUID)
}
