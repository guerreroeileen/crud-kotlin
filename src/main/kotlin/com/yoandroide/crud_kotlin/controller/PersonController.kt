package com.yoandroide.crud_kotlin.controller

import com.yoandroide.crud_kotlin.controller.dtos.PersonDto
import com.yoandroide.crud_kotlin.controller.responses.PersonResponse
import com.yoandroide.crud_kotlin.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


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

    @PatchMapping("/{id}")
    fun updatePartialPerson(@PathVariable id: String, @RequestBody map: Map<String, Any?>): ResponseEntity<PersonResponse> {
        val updatedPartialPerson = personService.updatePartialPerson(id, map)
        return ResponseEntity.status(HttpStatus.OK).body(updatedPartialPerson)
    }

    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id: UUID): ResponseEntity<Void> {
        return if (personService.deletePerson(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/status")
    fun testService(): ResponseEntity<String>{
        return ResponseEntity.ok("UP")
    }

}