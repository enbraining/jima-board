package dev.fodo.jimaboard.domain.board.dto

data class updateBoardRequest (
	val id: Long,
	val title: String,
	val content: String
)