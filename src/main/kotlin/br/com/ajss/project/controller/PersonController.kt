package br.com.ajss.project.controller

import br.com.ajss.project.data.vo.v1.PersonVO
import br.com.ajss.project.services.PersonService
import br.com.ajss.project.util.MediaType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//@CrossOrigin
@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for Managing People")
class PersonController {


    @Autowired
    private lateinit var service: PersonService
    // var service: PersonService = PersonService()

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    @Operation(summary = "Find all people", description = "Find all people recorded in the database",
        tags = ["People"],
        responses = [
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "List of people returned",
                responseCode = "200",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        array = io.swagger.v3.oas.annotations.media.ArraySchema(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = PersonVO::class
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
                                implementation = PersonVO::class
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
                                implementation = PersonVO::class
                            )
                        )
                    )
                ]
            )
        ]
    )


    fun findAll(): List<PersonVO> {
        return service.findAll()
    }

    @CrossOrigin(origins = ["http://localhost:8080"])
    @GetMapping(value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    @Operation(summary = "Finds a person", description = "Finds a person by ID",
        tags = ["People"],
        responses = [
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "List of people returned",
                responseCode = "200",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                            schema = io.swagger.v3.oas.annotations.media.Schema(
                                implementation = PersonVO::class
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
                                implementation = PersonVO::class
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
                                implementation = PersonVO::class
                            )
                        )
                    )
                ]
            )
        ]
    )
    fun findById(@PathVariable(value="id") id: Long): PersonVO {
        return service.findById(id)
    }

    @CrossOrigin(origins = ["http://localhost:8080", "https://ajss.com.br"])
    @PostMapping(consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    @Operation(summary = "Create a new person", description = "Create a new person",
        tags = ["People"],
        responses = [
            io.swagger.v3.oas.annotations.responses.ApiResponse(
                description = "List of people returned",
                responseCode = "200",
                content = [
                    io.swagger.v3.oas.annotations.media.Content(
                        schema = io.swagger.v3.oas.annotations.media.Schema(
                            implementation = PersonVO::class
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
                                implementation = PersonVO::class
                            )
                        )
                    )
                ]
            )
        ]
    )
    fun create(@RequestBody person: PersonVO): PersonVO {
        return service.create(person)

    }

    /*
    @PostMapping(value = ["/v2"], consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    fun createV2(@RequestBody person: PersonVO2): PersonVO2 {
        return service.createV2(person)

    }
    */

    @PutMapping(consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    @Operation(summary = "Update a person", description = "Update a person",
        tags = ["People"],
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
                                implementation = PersonVO::class
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
                                implementation = PersonVO::class
                            )
                        )
                    )
                ]
            )
        ]
    )
    fun update(@RequestBody person: PersonVO): PersonVO {
        return service.update(person)
    }

    @DeleteMapping(value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    @Operation(summary = "Delete a person", description = "Delete a person",
        tags = ["People"],
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
                                implementation = PersonVO::class
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
                                implementation = PersonVO::class
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