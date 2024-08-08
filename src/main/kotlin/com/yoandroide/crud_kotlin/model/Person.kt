package com.yoandroide.crud_kotlin.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        var id: UUID,
        var name: String = "",
        var lastName: String = "",
        var email: String = "",
        var age: Int = 0
)