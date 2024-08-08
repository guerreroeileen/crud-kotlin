package com.yoandroide.crud_kotlin.mapper

import com.yoandroide.crud_kotlin.controller.dtos.PersonDto
import com.yoandroide.crud_kotlin.controller.responses.PersonResponse
import com.yoandroide.crud_kotlin.model.Person
import java.util.*


fun Person.toPersonDto(): PersonDto {
    return PersonDto(
        lastName = lastName,
        name = name,
        email = email,
        age = age
    )
}
fun Person.toPersonResponse(): PersonResponse {
    return PersonResponse(
        id = id,
        lastName = lastName,
        name = name,
        email = email,
        age = age
    )
}


fun PersonDto.toPerson(): Person {
    return Person(
        id = UUID.randomUUID(),
        lastName = lastName,
        name = name,
        email = email,
        age = age
    )
}
