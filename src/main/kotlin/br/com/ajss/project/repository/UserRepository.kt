package br.com.ajss.project.repository

import br.com.ajss.project.model.Books
import br.com.ajss.project.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User?, Long?> {

    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    fun findByUserName(@Param("userName") userName: String?): User?

    fun findByFullName(fullName: String?): User?
    fun findByUserNameAndPassword(userName: String?, password: String?): User?
    fun findByUserNameAndFullName(userName: String?, fullName: String?): User?

}