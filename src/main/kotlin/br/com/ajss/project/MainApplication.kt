package br.com.ajss.project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder

// import java.util.HashMap
// import org.springframework.security.crypto.password.DelegatingPasswordEncoder
// import org.springframework.security.crypto.password.PasswordEncoder
// import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder

@SpringBootApplication
class MainApplication

fun main(args: Array<String>) {
	runApplication<MainApplication>(*args)

	/*
	val encoders: MutableMap<String, PasswordEncoder> = HashMap()
	val pbkdf2Enconder = Pbkdf2PasswordEncoder("", 8, 185000, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256)

	encoders["pbkdf2"] = pbkdf2Enconder
	val passwordEncoder = DelegatingPasswordEncoder("pbkdf2", encoders)
	passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Enconder)

	val result = passwordEncoder.encode("foo-bar")
	println("My hash $result")
	*/

}
