package br.com.ajss.project.services

import br.com.ajss.project.data.vo.v1.BooksVO
import br.com.ajss.project.exceptions.RequiredObjectIsNullException
import br.com.ajss.project.exceptions.ResourceNotFoundException
import br.com.ajss.project.mapper.DozerMapper
import br.com.ajss.project.mapper.custom.BooksMapper

import br.com.ajss.project.model.Books
import br.com.ajss.project.repository.BooksRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.awt.print.Book
import java.util.logging.Logger


@Service
class BooksService {

    @Autowired
    private lateinit var repository: BooksRepository

    @Autowired
    private lateinit var mapper: BooksMapper

    private val logger = Logger.getLogger(BooksService::class.java.name)

    fun findAll(): List<BooksVO> {
        logger.info("Finding all books!")
        val books = repository.findAll()
        val vos = DozerMapper.parseListObjects(books, BooksVO::class.java)

        /*
        vos.forEach { personVO ->
            val withSelfRel = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
            personVO.add(withSelfRel)
        }
         */
        return vos
    }

    fun findById(id: Long): BooksVO {
        logger.info("Finding one book with ID $id!")
        var book = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        val bookVO: BooksVO = DozerMapper.parseObject(book, BooksVO::class.java)
        /*
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRel)
         */
        return bookVO
    }

    fun create(book: BooksVO?) : BooksVO{
        if (book == null) throw RequiredObjectIsNullException()
        logger.info("Creating one book with title ${book.title}!")
        var entity: Books = DozerMapper.parseObject(book, Books::class.java)
        val booksVO: BooksVO =  DozerMapper.parseObject(repository.save(entity), BooksVO::class.java)
        /*
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRel)
         */
        return booksVO
    }

    fun update(book: BooksVO?) : BooksVO{
        if (book == null) throw RequiredObjectIsNullException()
        logger.info("Updating one book with ID ${book.key}!")
        val entity = repository.findById(book.key)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.author = book.author
        entity.launchDate = book.launchDate
        entity.price = book.price
        entity.title = book.title
        val bookVo: BooksVO = DozerMapper.parseObject(repository.save(entity), BooksVO::class.java)
        /*
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRel)

         */
        return bookVo
    }

    fun delete(id: Long) {
        logger.info("Deleting one book with ID $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}