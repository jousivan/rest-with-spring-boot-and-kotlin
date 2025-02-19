package br.com.ajss.project.repository

import br.com.ajss.project.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository: JpaRepository<Person, Long?>