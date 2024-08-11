package org.example.exception

import java.util.*

class PersonNotFoundException(id: UUID): RuntimeException("Person with id $id not found") {
}