package com.yoandroide.crud_kotlin.controller

import com.yoandroide.crud_kotlin.controller.dtos.PersonDto
import com.yoandroide.crud_kotlin.controller.responses.PersonResponse
import com.yoandroide.crud_kotlin.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/person")
class PersonController (private val personService: PersonService) {

    @GetMapping("/")
    fun getAllPerson(): ResponseEntity<List<PersonDto>> {
        return ResponseEntity.ok(personService.getAllPersons())
    }

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable id: UUID): ResponseEntity<PersonResponse> {
        val personResponse = personService.getPersonById(id)
        return ResponseEntity.ok(personResponse)
    }

    @PostMapping
    fun createPerson(@RequestBody personDTO: PersonDto): ResponseEntity<PersonResponse> {
        val createdPerson = personService.createPerson(personDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson)
    }

    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id: UUID): ResponseEntity<Void> {
        return if (personService.deletePerson(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

}