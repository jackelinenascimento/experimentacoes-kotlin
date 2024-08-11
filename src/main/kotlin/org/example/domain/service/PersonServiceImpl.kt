package org.example.domain.service

import org.example.domain.model.Person
import org.example.domain.repository.PersonRepository
import java.util.UUID

class PersonServiceImpl(private val personRepository: PersonRepository) {
    fun save(person: Person) {
        personRepository.save(person)
    }

    fun findById(id: UUID): Person? {
        return personRepository.findById(id)
    }

    fun findAll(): List<Person> {
        return personRepository.findAll()
    }

    fun deleteById(id: UUID) {
        personRepository.deleteById(id)
    }
}
