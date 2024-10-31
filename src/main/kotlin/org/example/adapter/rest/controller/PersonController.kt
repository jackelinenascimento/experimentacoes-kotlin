package org.example.adapter.rest.controller

import jakarta.validation.Valid
import org.example.adapter.rest.dto.PersonRequestDTO
import org.example.adapter.rest.dto.PersonResponseDTO
import org.example.domain.model.Person
import org.example.domain.ports.input.PersonInputPort
import org.example.exception.EntityNotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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

    private val logger: Logger = LoggerFactory.getLogger(PersonController::class.java)

    @PostMapping
    fun savePerson(
        @Valid @RequestBody
        personRequestDTO: PersonRequestDTO
    ): ResponseEntity<PersonResponseDTO> {
        logger.info("action=PersonController.savePerson - request: $personRequestDTO" )

        val person = personRequestDTO.toDomain()
        val savedPerson = personInputPort.savePerson(person)
        return ResponseEntity(PersonResponseDTO.fromDomain(savedPerson), HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllPersons(): ResponseEntity<List<Person>> {
        logger.info("action=PersonController.getAllPersons")

        val persons = personInputPort.getAllPersons()
        if (persons.isEmpty()) {
            throw EntityNotFoundException("No persons found")
        }
        return ResponseEntity(persons, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable id: UUID): ResponseEntity<Person> {
        logger.info("action=PersonController.getPersonById - id: $id")

        val person = personInputPort.getPersonById(id) ?: throw EntityNotFoundException("Person with id $id not found")
        return ResponseEntity(person, HttpStatus.OK)
    }

    @DeleteMapping
    fun deletePersonById(@PathVariable id: UUID): ResponseEntity<Unit> {
        logger.info("action=PersonController.deletePersonById - id: $id")

        personInputPort.deletePerson(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
