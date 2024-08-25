package org.example.adapter.repository

import org.example.adapter.repository.entity.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SpringPersonRepository : JpaRepository<PersonEntity, UUID>
