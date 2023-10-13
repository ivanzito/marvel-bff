package br.com.ivan.marvel.client

import CharactersRepository
import br.com.ivan.marvel.client.port.dto.MarvelWrapper
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CharacterClient(
    private val marvelClient: MarvelClient) : CharactersRepository {

    private val restTemplate = RestTemplate()


    override fun characters() =
        restTemplate.getForObject(marvelClient.url("/characters"), MarvelWrapper::class.java)
    override fun character(id: String) =
        restTemplate.getForObject(marvelClient.url("/characters", id), MarvelWrapper::class.java)
    override fun characterStartsWith(name: String) =
        restTemplate.getForObject(marvelClient.url("/characters", Pair("nameStartsWith", name)), MarvelWrapper::class.java)
    override fun characterByName(name: String) =
        restTemplate.getForObject(marvelClient.url("/characters", Pair("name", name)), MarvelWrapper::class.java)
    override fun stories(id: String) =
        restTemplate.getForObject(marvelClient.url("/characters", id, "/stories"), MarvelWrapper::class.java)
    override fun series(id: String) =
        restTemplate.getForObject(marvelClient.url("/characters", id, "/series"), MarvelWrapper::class.java)
    override fun comics(id: String) =
        restTemplate.getForObject(marvelClient.url("/characters", id, "/comics"), MarvelWrapper::class.java)
    override fun events(id: String) =
        restTemplate.getForObject(marvelClient.url("/characters", id, "/events"), MarvelWrapper::class.java)
}