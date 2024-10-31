package org.example.domain.ports.output

import org.example.domain.model.Person
import java.util.UUID

interface PersonRepository {
    fun save(person: Person): Person
    fun findById(id: UUID): Person?
    fun update(person: Person): Person
    fun deleteById(id: UUID)
    fun findAll(): List<Person>
}
