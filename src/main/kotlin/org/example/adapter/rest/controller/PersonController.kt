package org.example.adapter.rest.controller

import jakarta.validation.Valid
import org.example.adapter.rest.dto.PersonRequestDTO
import org.example.adapter.rest.dto.PersonResponseDTO
import org.example.domain.model.Person
import org.example.domain.ports.input.PersonInputPort
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
class PersonController(private val personInputPort: PersonInputPort) {

    @PostMapping
    fun savePerson(@Valid @RequestBody personRequestDTO: PersonRequestDTO): ResponseEntity<PersonResponseDTO> {
        val person = personRequestDTO.toDomain()
        val savedPerson = personInputPort.savePerson(person)
        return ResponseEntity(PersonResponseDTO.fromDomain(savedPerson), HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllPersons(): ResponseEntity<List<Person>> {
        val persons = personInputPort.getAllPersons()
        if (persons.isEmpty()) {
            throw EntityNotFoundException("No persons found")
        }
        return ResponseEntity(persons, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable id: UUID): ResponseEntity<Person> {
        val person = personInputPort.getPersonById(id) ?: throw EntityNotFoundException("Person with id $id not found")
        return ResponseEntity(person, HttpStatus.OK)
    }

    @DeleteMapping
    fun deletePersonById(@PathVariable id: UUID): ResponseEntity<Unit> {
        personInputPort.deletePerson(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
