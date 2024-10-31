package org.example.domain.ports.input

import org.example.domain.model.Person
import java.util.UUID

interface PersonInputPort {
    fun savePerson(person: Person): Person
    fun getPersonById(id: UUID): Person?
    fun updatePerson(id: UUID, person: Person): Person
    fun deletePerson(id: UUID)
    fun getAllPersons(): List<Person>
}
