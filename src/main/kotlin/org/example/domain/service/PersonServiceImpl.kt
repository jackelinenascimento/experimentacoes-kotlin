package org.example.domain.service

import org.example.domain.model.Person
import org.example.domain.repository.PersonRepository
import org.example.exception.PersonNotFoundException
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PersonServiceImpl(private val personRepository: PersonRepository) : PersonService {
    override fun save(person: Person): Person {
        return this.personRepository.save(person)
    }

    override fun findById(id: UUID): Person {
        return personRepository.findById(id) ?: throw PersonNotFoundException(id)
    }

    override fun findAll(): List<Person> {
        return personRepository.findAll()
    }

    override fun deleteById(id: UUID) {
        personRepository.deleteById(id)
    }
}
