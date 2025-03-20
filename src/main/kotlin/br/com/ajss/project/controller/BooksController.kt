package br.com.ajss.project.controller

import br.com.ajss.project.data.vo.v1.BooksVO
import br.com.ajss.project.data.vo.v1.PersonVO
import br.com.ajss.project.model.Books
import br.com.ajss.project.services.BooksService
import br.com.ajss.project.services.PersonService
import br.com.ajss.project.util.MediaType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.awt.print.Book

@RestController
@RequestMapping("/api/books/v1")
@Tag(name = "Books", description = "Endpoints for Managing Books")
class BooksController {


    @Autowired
    private lateinit var service: BooksService

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    @Operation(summary = "Find all books", description = "Find all books recorded in the database",
        tags = ["Books"],
        responses = [
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "List of books returned",
                responseCode = "200",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = BooksVO::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "No Content",
                responseCode = "204",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Unauthorized",
                responseCode = "401",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Not Found",
                responseCode = "404",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = BooksVO::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Internal Server Error",
                responseCode = "500",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = BooksVO::class
                            )
                        )
                    )
                ]
            )
        ]
    )
    fun findAll(): List<BooksVO> {
        return service.findAll()
    }

    @GetMapping(value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    @Operation(summary = "Finds a book", description = "Finds a book by ID",
        tags = ["Books"],
        responses = [
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "List of book returned",
                responseCode = "200",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = BooksVO::class
                            )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "No Content",
                responseCode = "204",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Unauthorized",
                responseCode = "401",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Not Found",
                responseCode = "404",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = BooksVO::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Internal Server Error",
                responseCode = "500",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = BooksVO::class
                            )
                        )
                    )
                ]
            )
        ]
    )
    fun findById(@PathVariable(value="id") id: Long): BooksVO {
        return service.findById(id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    @Operation(summary = "Create a new book", description = "Create a new book",
        tags = ["Books"],
        responses = [
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "List of book returned",
                responseCode = "200",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        schema = io.swagger.v3.oas.annotations.media.Schema(
                            implementation = BooksVO::class
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Unauthorized",
                responseCode = "401",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Internal Server Error",
                responseCode = "500",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = BooksVO::class
                            )
                        )
                    )
                ]
            )
        ]
    )
    fun create(@RequestBody book: BooksVO): BooksVO {
        return service.create(book)

    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    @Operation(summary = "Update a book", description = "Update a book",
        tags = ["Books"],
        responses = [
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "No Content",
                responseCode = "204",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Unauthorized",
                responseCode = "401",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Not Found",
                responseCode = "404",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = BooksVO::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Internal Server Error",
                responseCode = "500",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = BooksVO::class
                            )
                        )
                    )
                ]
            )
        ]
    )
    fun update(@RequestBody person: BooksVO): BooksVO {
        return service.update(person)
    }

    @DeleteMapping(value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    @Operation(summary = "Delete a book", description = "Delete a book",
        tags = ["Books"],
        responses = [
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "No Content",
                responseCode = "204",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Unauthorized",
                responseCode = "401",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = Unit::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Not Found",
                responseCode = "404",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = BooksVO::class
                            )
                        )
                    )
                ]
            ),
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "Internal Server Error",
                responseCode = "500",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = BooksVO::class
                            )
                        )
                    )
                ]
            )
        ]
    )
    fun delete(@PathVariable(value="id") id: Long) : ResponseEntity<*>{
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}