package org.example.domain.service

import org.example.domain.model.Person
import org.example.domain.ports.input.PersonInputPort
import org.example.domain.ports.output.PersonRepository
import org.example.exception.PersonNotFoundException
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PersonService(private val personRepository: PersonRepository) : PersonInputPort {

    override fun savePerson(person: Person): Person {
        return personRepository.save(person)
    }

    override fun getPersonById(id: UUID): Person? {
        return personRepository.findById(id)
    }

    override fun updatePerson(id: UUID, person: Person): Person {
        val existingPerson = personRepository.findById(id) ?: throw PersonNotFoundException(id)
        val updatedPerson = existingPerson.copy(name = person.name, age = person.age)
        return personRepository.update(updatedPerson)
    }

    override fun deletePerson(id: UUID) {
        personRepository.deleteById(id)
    }

    override fun getAllPersons(): List<Person> {
        return personRepository.findAll()
    }
}
