package com.yoandroide.crud_kotlin.controller.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.io.Serializable

data class PersonDto(
    @field:NotEmpty(message = "Name must not be empty")
    var name: String,
    @field:NotEmpty(message = "Last name must not be empty")
    var lastName: String,
    @field:Email(message = "Email should be valid")
    var email: String,
    @field:NotNull(message = "Age must not be null")
    @field:Positive(message = "Age must be positive")
    var age: Int
) : Serializable


















