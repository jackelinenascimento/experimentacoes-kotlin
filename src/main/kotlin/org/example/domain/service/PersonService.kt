package org.example.domain.service

import org.example.domain.model.Person
import org.springframework.stereotype.Service
import java.util.UUID

@Service
interface PersonService {
    fun save(person: Person): Person
    fun findById(id: UUID): Person?
    fun findAll(): List<Person>
    fun deleteById(id: UUID)
}
