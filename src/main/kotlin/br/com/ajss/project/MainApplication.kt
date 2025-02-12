package br.com.ajss.project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestWithSpringBootAndKotlinApplication

fun main(args: Array<String>) {
	runApplication<RestWithSpringBootAndKotlinApplication>(*args)
}
