package dev.fodo.jimaboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JimaBoardApplication

fun main(args: Array<String>) {
	runApplication<JimaBoardApplication>(*args)
}
