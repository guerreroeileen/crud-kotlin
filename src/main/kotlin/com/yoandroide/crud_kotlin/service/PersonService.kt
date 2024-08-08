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

    fun deletePerson(id: UUID): Boolean {
        return if (personRepository.existsById(id)) {
            personRepository.deleteById(id)
            true
        } else {
            false
        }
    }

}