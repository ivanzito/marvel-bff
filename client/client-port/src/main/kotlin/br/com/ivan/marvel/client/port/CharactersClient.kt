package br.com.ivan.marvel.client.port

import br.com.ivan.marvel.client.port.output.CharacterResponse

interface CharactersClient {
    fun character(id: String, offset: Int?, limit: Int?): List<CharacterResponse>
    fun characterStartsWith(name: String?, offset: Int?, limit: Int?): List<CharacterResponse>
    fun characterByName(name: String, offset: Int?, limit: Int?): List<CharacterResponse>
}