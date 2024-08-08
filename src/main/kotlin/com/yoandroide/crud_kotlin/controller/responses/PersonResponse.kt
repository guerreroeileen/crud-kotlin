package com.yoandroide.crud_kotlin.controller.responses

import java.io.Serializable
import java.util.UUID

data class PersonResponse(
    val id: UUID,
    val name: String,
    val lastName: String,
    val email: String,
    val age: Int
): Serializable


















