package br.com.ajss.project.services

import br.com.ajss.project.controller.BooksController
import br.com.ajss.project.controller.PersonController
import br.com.ajss.project.data.vo.v1.BooksVO
import br.com.ajss.project.data.vo.v1.PersonVO
import br.com.ajss.project.exceptions.RequiredObjectIsNullException
import br.com.ajss.project.exceptions.ResourceNotFoundException
import br.com.ajss.project.mapper.DozerMapper
import br.com.ajss.project.mapper.custom.BooksMapper

import br.com.ajss.project.model.Books
import br.com.ajss.project.repository.BooksRepository
import br.com.ajss.project.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class UserService(@field:Autowired var repository: UserRepository) : UserDetailsService {

    private val logger = Logger.getLogger(UserService::class.java.name)

    override fun loadUserByUsername(username: String?): UserDetails {
        logger.info("Finding user by username $username")
        val user = repository.findByUserName(username)
        return user ?: throw UsernameNotFoundException("Username $username not found")

    }


}