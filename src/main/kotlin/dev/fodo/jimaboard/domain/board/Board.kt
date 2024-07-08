package dev.fodo.jimaboard.domain.board

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
data class Board (
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long?,

	val title: String,

	val content: String
)