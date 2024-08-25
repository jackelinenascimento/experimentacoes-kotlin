package org.example.domain.service

import org.example.domain.model.Person
import org.example.domain.port.PersonRepositoryPort
import org.example.exception.PersonNotFoundException
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PersonService(private val personRepository: PersonRepositoryPort) {

    fun save(person: Person): Person {
        return this.personRepository.save(person)
    }

    fun findById(id: UUID): Person {
        return personRepository.findById(id) ?: throw PersonNotFoundException(id)
    }

    fun findAll(): List<Person> {
        return personRepository.findAll()
    }

    fun deleteById(id: UUID) {
        personRepository.deleteById(id)
    }
}
