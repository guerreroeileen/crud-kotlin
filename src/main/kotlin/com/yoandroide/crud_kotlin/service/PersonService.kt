package com.yoandroide.crud_kotlin.service

import com.yoandroide.crud_kotlin.controller.dtos.PersonDto
import com.yoandroide.crud_kotlin.controller.responses.PersonResponse
import com.yoandroide.crud_kotlin.exception.ResourceNotFoundException
import com.yoandroide.crud_kotlin.mapper.toPerson
import com.yoandroide.crud_kotlin.mapper.toPersonDto
import com.yoandroide.crud_kotlin.mapper.toPersonResponse
import com.yoandroide.crud_kotlin.repository.IPersonRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService (
    private val personRepository: IPersonRepository
) {

    fun getAllPersons(): List<PersonDto> {
        val persons = personRepository.findAll()
        return persons.map { it.toPersonDto() }
    }

    fun getPersonById(id: UUID): PersonResponse {
        val person = personRepository.findById(id).orElseThrow { ResourceNotFoundException("Person not found with id: $id") }
        return person.toPersonResponse()
    }

    fun createPerson(personDTO: PersonDto): PersonResponse {
        val person = personDTO.toPerson()
        val savedPerson = personRepository.save(person)
        return savedPerson.toPersonResponse()
    }
    fun updatePartialPerson(id: String, updates: Map<String, Any?>): PersonResponse {
        val convertedId = UUID.fromString(id)
        val personToBeUpdated =  personRepository.findById(convertedId).orElseThrow{ResourceNotFoundException("Person not found with id: $id")}
        updates.forEach { (key, value) ->
            when (key) {
                "name" -> personToBeUpdated.name = value as String
                "lastName" -> personToBeUpdated.lastName = value as String
                "email" -> personToBeUpdated.email = value as String
                "age" -> personToBeUpdated.age = value as Int
            }
        }
        return personRepository.save(personToBeUpdated).toPersonResponse()

    }

    fun deletePerson(id: UUID): Boolean {
        return if (personRepository.existsById(id)) {
            personRepository.deleteById(id)
            true
        } else {
            false
        }
    }

}