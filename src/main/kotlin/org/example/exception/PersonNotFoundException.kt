package org.example.exception

import java.util.UUID

class PersonNotFoundException(id: UUID) : RuntimeException("Person with id $id not found")
