package br.com.ajss.project.repository

import br.com.ajss.project.model.Books
import org.springframework.data.jpa.repository.JpaRepository

interface BooksRepository: JpaRepository<Books, Long?>