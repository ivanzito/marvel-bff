package br.com.ivan.marvel.controller

import br.com.ivan.marvel.client.port.CharactersClient
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@RestController
@RequestMapping("/marvel/characters")
class CharacterController(private val charactersClient: CharactersClient) {

    private val logger = Logger.getLogger(this::class.java.name)


    @GetMapping
    fun characters(
        @RequestParam(required = false, name = "startsWith") startsWith: String?,
        @RequestParam(required = false, name = "offset") offset: Int?,
        @RequestParam(required = false, name = "limit") limit: Int?
    ) = ResponseEntity
            .status(HttpStatus.OK)
            .body(charactersClient.characterStartsWith(startsWith, offset, limit))


    @GetMapping("/{id}")
    fun charactersById(
        @PathVariable("id") id: String,
        @RequestParam(required = false, name = "offset") offset: Int?,
        @RequestParam(required = false, name = "limit") limit: Int?
    ) = ResponseEntity
            .status(HttpStatus.OK)
            .body(charactersClient.character(id, offset, limit))
}