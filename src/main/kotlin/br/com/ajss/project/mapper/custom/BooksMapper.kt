package br.com.ajss.project.mapper.custom

import br.com.ajss.project.data.vo.v1.BooksVO
import br.com.ajss.project.data.vo.v2.PersonVO
import br.com.ajss.project.model.Books
import br.com.ajss.project.model.Person
import org.springframework.stereotype.Service
import java.util.Date

@Service
class BooksMapper {

    fun mapEntityToVO(books: Books): BooksVO {
        val vo = BooksVO()
        vo.id = books.id
        vo.author = books.author
        vo.launchDate = Date()
        vo.price = books.price
        vo.title = books.title
        return vo
    }

    fun mapVOToEntity(books: BooksVO): Books {
        val entity = Books()
        entity.id = books.id
        entity.author = books.author
        entity.launchDate = books.launchDate
        entity.price = books.price
        entity.title = books.title
        return entity
    }

}