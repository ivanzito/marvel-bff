package br.com.ivan.marvel.controller

import CharactersRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/marvel/characters")
class CharacterController(val charactersRepository: CharactersRepository) {
    @GetMapping
    fun characters(
        //@RequestParam(required = false, name = "name") name: String?,
        @RequestParam(required = true, name = "startsWith") startsWith: String) =
        charactersRepository.characterStartsWith(startsWith)
    @GetMapping("/{id}")
    fun charactersById(@PathVariable("id") id: String) =
        charactersRepository.character(id)

    @GetMapping("/{id}/events")
    fun events(@PathVariable("id") id: String) =
        charactersRepository.events(id)

    @GetMapping("/{id}/series")
    fun series(@PathVariable("id") id: String) =
        charactersRepository.series(id)

    @GetMapping("/{id}/stories")
    fun stories(@PathVariable("id") id: String) =
        charactersRepository.stories(id)

    @GetMapping("/{id}/comics")
    fun comics(@PathVariable("id") id: String) =
        charactersRepository.comics(id);
}