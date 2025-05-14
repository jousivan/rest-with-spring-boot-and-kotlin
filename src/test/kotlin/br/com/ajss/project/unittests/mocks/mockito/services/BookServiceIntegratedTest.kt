package br.com.ajss.project.integration

    import br.com.ajss.project.data.vo.v1.BooksVO
    import br.com.ajss.project.repository.BooksRepository
    import br.com.ajss.project.services.BooksService
    import br.com.ajss.project.unittests.mocks.MockBooks
    import io.restassured.RestAssured
    import io.restassured.http.ContentType
    import org.hamcrest.Matchers.*
    import org.junit.jupiter.api.BeforeEach
    import org.junit.jupiter.api.Disabled
    import org.junit.jupiter.api.Test
    import org.mockito.InjectMocks
    import org.mockito.Mock
    import org.mockito.Mockito.`when`
    import org.springframework.beans.factory.annotation.Autowired
    import org.springframework.boot.test.context.SpringBootTest
    import org.springframework.boot.test.web.server.LocalServerPort
    import org.springframework.http.HttpStatus
    import org.springframework.test.context.ActiveProfiles
    import org.springframework.web.context.WebApplicationContext
    import java.util.*

    @Disabled
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @ActiveProfiles("test")
    class BooksControllerIntegrationTest {

        @LocalServerPort
        private var port: Int = 0

        @Autowired
        private lateinit var context: WebApplicationContext

        private lateinit var inputObject: MockBooks

        @InjectMocks
        private lateinit var service: BooksService

        @Mock
        private lateinit var repository: BooksRepository

        @BeforeEach
        fun setUp() {
            RestAssured.port = port
        }

        @Test
        fun findAll_returnsListOfBooksVO() {
            RestAssured.given()
                .contentType(ContentType.JSON)
                .`when`()
                .get("/api/books")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0))
        }

        @Test
        fun findById_existingId_returnsBooksVO() {
            val bookId = 1L
            RestAssured.given()
                .contentType(ContentType.JSON)
                .`when`()
                .get("/api/books/$bookId")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body("id", equalTo(bookId.toInt()))
        }

        @Test
        fun findById_nonExistingId_returnsNotFound() {
            val bookId = 999L
            RestAssured.given()
                .contentType(ContentType.JSON)
                .`when`()
                .get("/api/books/$bookId")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value())
        }

        @Test
        fun create_validBook_returnsBooksVO() {

            val entity = inputObject.mockEntity(1)

            val persisted = entity.copy()
            persisted.id = 1

            `when`(repository.save(entity)).thenReturn(persisted)

            val vo = inputObject.mockVO(1)

            val book = BooksVO(1L, "New Title", Date(), 15.0)

            RestAssured.given()
                .contentType(ContentType.JSON)
                .body(book)
                .`when`()
                .post("/api/books")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .contentType(ContentType.JSON)
                .body("title", equalTo("New Title"))
        }

        @Test
        fun create_nullBook_returnsBadRequest() {
            RestAssured.given()
                .contentType(ContentType.JSON)
                .body(null as Any?)
                .`when`()
                .post("/api/books")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
        }

        @Test
        fun update_existingBook_returnsUpdatedBooksVO() {
            val book = BooksVO(1L, "Updated Title", Date(), 20.0)
            RestAssured.given()
                .contentType(ContentType.JSON)
                .body(book)
                .`when`()
                .put("/api/books")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body("title", equalTo("Updated Title"))
        }

        @Test
        fun update_nonExistingBook_returnsNotFound() {
            val book = BooksVO(999L, "Updated Title", Date(), 20.0)
            RestAssured.given()
                .contentType(ContentType.JSON)
                .body(book)
                .`when`()
                .put("/api/books")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value())
        }

        @Test
        fun delete_existingId_returnsNoContent() {
            val bookId = 1L
            RestAssured.given()
                .contentType(ContentType.JSON)
                .`when`()
                .delete("/api/books/$bookId")
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value())
        }

        @Test
        fun delete_nonExistingId_returnsNotFound() {
            val bookId = 999L
            RestAssured.given()
                .contentType(ContentType.JSON)
                .`when`()
                .delete("/api/books/$bookId")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value())
        }
    }