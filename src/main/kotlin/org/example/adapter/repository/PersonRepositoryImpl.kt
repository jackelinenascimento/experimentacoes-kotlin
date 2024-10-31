package org.example.adapter.repository

import org.example.adapter.repository.entity.PersonEntity
import org.example.adapter.repository.jpa.PersonJpaRepository
import org.example.domain.model.Person
import org.example.domain.ports.output.PersonRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class PersonRepositoryImpl(private val personJpaRepository: PersonJpaRepository): PersonRepository {
    override fun save(person: Person): Person {
        val personEntity = PersonEntity.fromDomain(person)
        return personJpaRepository.save(personEntity).toDomain()
    }

    override fun findById(id: UUID): Person? {
        return personJpaRepository.findById(id).map { it.toDomain() }.orElse(null)
    }

    override fun update(person: Person): Person {
        val personEntity = PersonEntity.fromDomain(person)
        return personJpaRepository.save(personEntity).toDomain()
    }

    override fun deleteById(id: UUID) {
        personJpaRepository.deleteById(id)
    }

    override fun findAll(): List<Person> {
        return personJpaRepository.findAll().map { it.toDomain() }
    }
}
