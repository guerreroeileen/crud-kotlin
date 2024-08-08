package com.yoandroide.crud_kotlin.repository

import com.yoandroide.crud_kotlin.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface IPersonRepository : JpaRepository<Person, UUID>
