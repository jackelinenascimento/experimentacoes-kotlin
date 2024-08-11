package org.example.adapter.repository

import org.example.domain.model.Person
import org.example.domain.repository.PersonRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class InMemoryPersonRepository : PersonRepository {

    private val persons: MutableMap<UUID, Person> = mutableMapOf()

    override fun save(person: Person) {
        persons[person.id] = person
    }

    override fun findById(id: UUID): Person? {
        return persons[id]
    }

    override fun findAll(): List<Person> {
        return persons.values.toList()
    }

    override fun deleteById(id: UUID) {
        persons.remove(id)
    }
}
