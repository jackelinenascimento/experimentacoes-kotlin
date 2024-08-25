package org.example.adapter.rest

import org.example.adapter.repository.entity.PersonEntity
import org.example.domain.model.Person
import org.example.domain.service.PersonService
import org.example.exception.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/persons")
class PersonController(private val personService: PersonService) {

    @PostMapping
    fun savePerson(@RequestBody personEntity: PersonEntity): ResponseEntity<Person> {
        val savedPerson = personService.save(personEntity.toDomain())
        return ResponseEntity(savedPerson, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllPersons(): ResponseEntity<List<Person>> {
        val persons = personService.findAll()
        if (persons.isEmpty()) {
            throw EntityNotFoundException("No persons found")
        }
        return ResponseEntity(persons, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable id: UUID): ResponseEntity<Person> {
        val person = personService.findById(id)
        return ResponseEntity(person, HttpStatus.OK)
    }

    @DeleteMapping
    fun deletePersonById(@PathVariable id: UUID): ResponseEntity<Unit> {
        personService.deleteById(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
