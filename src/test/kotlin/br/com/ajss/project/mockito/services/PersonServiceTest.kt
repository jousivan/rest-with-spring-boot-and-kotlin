package br.com.ajss.project.mockito.services

import br.com.ajss.project.exceptions.RequiredObjectIsNullException
import br.com.ajss.project.mocks.MockPerson
import br.com.ajss.project.repository.PersonRepository
import br.com.ajss.project.services.PersonService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertThrows

import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.util.*

@ExtendWith(MockitoExtension::class)
class PersonServiceTest {

   private lateinit var inputObject: MockPerson

   @InjectMocks
   private lateinit var service: PersonService

   @Mock
   private lateinit var repository: PersonRepository



    @BeforeEach
    fun setUp() {
     inputObject = MockPerson()
     MockitoAnnotations.openMocks(this)
    }

   @Test
    fun findAll() {
       val list = inputObject.mockEntityList()

       `when`(repository.findAll()).thenReturn(list)

       val persons = service.findAll()

       assertNotNull(persons)
       assertEquals(14, persons.size)

       val personOne = persons[1]

       assertNotNull(personOne)
       assertNotNull(personOne.key)
       assertNotNull(personOne.links)
       assertTrue(personOne.links.toString().contains("</api/person/v1/0>;rel=\"self\""))
       assertEquals("First Name Test1", personOne.firstName)
       assertEquals("Last Name Test1", personOne.lastName)
       assertEquals("Address Test1", personOne.address)
       assertEquals("Female", personOne.gender)

       val personFour = persons[4]

       assertNotNull(personFour)
       assertNotNull(personFour.key)
       assertNotNull(personFour.links)
       assertTrue(personFour.links.toString().contains("</api/person/v1/0>;rel=\"self\""))
       assertEquals("First Name Test4", personFour.firstName)
       assertEquals("Last Name Test4", personFour.lastName)
       assertEquals("Address Test4", personFour.address)
       assertEquals("Male", personFour.gender)

    }

   @Test
    fun findById() {
      val person = inputObject.mockEntity(1)
       person.id = 1
       `when`(repository.findById(1)).thenReturn(Optional.of(person))

       val result = service.findById(1)
       assertNotNull(result)
       assertNotNull(result.key)
       assertNotNull(result.links)
       assertTrue(result.links.toString().contains("</api/person/v1/0>;rel=\"self\""))
       assertEquals("First Name Test1", result.firstName)
       assertEquals("Last Name Test1", result.lastName)
       assertEquals("Address Test1", result.address)
       assertEquals("Female", result.gender)
    }

   @Test
    fun create() {
       val entity = inputObject.mockEntity(0)

       val persisted = entity.copy()
       persisted.id = 0

       given(repository.save(entity)).willReturn(persisted)

       val vo = inputObject.mockVO(0)
       val result = service.create(vo)

       assertNotNull(result)
       assertNotNull(result.key)
       assertNotNull(result.links)
       assertTrue(result.links.toString().contains("</api/person/v1/0>;rel=\"self\""))
       assertEquals("First Name Test0", result.firstName)
       assertEquals("Last Name Test0", result.lastName)
       assertEquals("Address Test0", result.address)
       assertEquals("Male", result.gender)

    }

    @Test
    fun createWithNullPerson() {
        val exception: RequiredObjectIsNullException = assertThrows {
            service.create(null)
        }

        val expectedMessage = "It is not possible to proceed with a null object."
        val actualMessage = exception.message
        assertTrue(actualMessage!!.contains(expectedMessage))

    }

    @Test
    fun updateWithNullPerson() {
        val exception: RequiredObjectIsNullException = assertThrows {
            service.update(null)
        }

        val expectedMessage = "It is not possible to proceed with a null object."
        val actualMessage = exception.message
        assertTrue(actualMessage!!.contains(expectedMessage))

    }


   @Test
    fun update() {

       val entity = inputObject.mockEntity(1)

       val persisted = entity.copy()
       persisted.id = 1

       `when`(repository.findById(1)).thenReturn(Optional.of(entity))
       `when`(repository.save(entity)).thenReturn(persisted)

       val vo = inputObject.mockVO(1)
       val result = service.update(vo)

       assertNotNull(result)
       assertNotNull(result.key)
       assertNotNull(result.links)
       assertTrue(result.links.toString().contains("</api/person/v1/0>;rel=\"self\""))
       assertEquals("First Name Test1", result.firstName)
       assertEquals("Last Name Test1", result.lastName)
       assertEquals("Address Test1", result.address)
       assertEquals("Female", result.gender)
    }

   @Test
    fun delete() {
       val entity = inputObject.mockEntity(1)

       `when`(repository.findById(1)).thenReturn(Optional.of(entity))
       service.delete(1)

    }
}