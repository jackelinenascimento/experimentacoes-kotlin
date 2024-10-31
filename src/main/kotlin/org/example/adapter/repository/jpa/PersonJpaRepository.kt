package org.example.adapter.repository.jpa

import org.example.adapter.repository.entity.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface PersonJpaRepository: JpaRepository<PersonEntity, UUID> {
    override fun findById(id: UUID): Optional<PersonEntity>
    override fun deleteById(id: UUID)
    override fun findAll(): List<PersonEntity>
    fun save(person: PersonEntity): PersonEntity
}
