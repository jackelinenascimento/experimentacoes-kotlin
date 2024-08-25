package org.example.adapter.repository

import org.example.adapter.repository.entity.PersonEntity
import org.example.domain.model.Person
import org.example.domain.port.PersonRepositoryPort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class PersonRepositoryImp(private val springPersonRepository: SpringPersonRepository) : PersonRepositoryPort {
    override fun save(person: Person): Person {
        val personEntity = PersonEntity.fromDomain(person)
        return springPersonRepository.save(personEntity).toDomain()
    }

    override fun findAll(): List<Person> {
        return springPersonRepository.findAll().map { it.toDomain() }
    }

    override fun findById(id: UUID): Person? {
        return springPersonRepository.findById(id).map { it.toDomain() }.orElse(null)
    }

    override fun deleteById(id: UUID) {
        springPersonRepository.deleteById(id)
    }
}
