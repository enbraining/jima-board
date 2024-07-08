package dev.fodo.jimaboard.domain.board

import dev.fodo.jimaboard.domain.board.dto.CreateBoardRequest
import dev.fodo.jimaboard.domain.board.dto.updateBoardRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/board")
class BoardController(
	private val boardRepository: BoardRepository
) {
	@GetMapping
	fun fetchBoards(): ResponseEntity<Any> {
		return ResponseEntity.ok(boardRepository.findAll());
	}

	@PostMapping
	fun createBoard(@RequestBody createBoardRequest: CreateBoardRequest){
		boardRepository.save(Board(
			id = null,
			title = createBoardRequest.title,
			content = createBoardRequest.content
		))
	}

	@PutMapping
	fun updateBoard(@RequestBody updateBoardRequest: updateBoardRequest){
		val board = boardRepository.getReferenceById(updateBoardRequest.id)
		boardRepository.save(
			board.copy(title = updateBoardRequest.title, content = updateBoardRequest.content)
		)
	}

	@DeleteMapping("/{id}")
	fun deleteBoard(@PathVariable id: Long){
		boardRepository.deleteById(id)
	}
}