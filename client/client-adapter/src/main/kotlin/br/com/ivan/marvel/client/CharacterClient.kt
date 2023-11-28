package br.com.ivan.marvel.client

import br.com.ivan.marvel.client.port.CharactersClient
import org.springframework.stereotype.Service

@Service
class CharacterClient(private val marvelClient: MarvelClient) : CharactersClient {

        override fun character(id: String, offset: Int?, limit: Int?) = marvelClient.call(
            path = "/characters",
            offset = offset,
            limit = limit)
        override fun characterStartsWith(name: String?, offset: Int?, limit: Int?) =
            name?.let {
                marvelClient.call(
                    path = "/characters",
                    limit = limit,
                    offset = offset,
                    param = Pair("nameStartsWith", name))
            } ?:
            marvelClient.call(
                path = "/characters",
                limit = limit,
                offset = offset)

        override fun characterByName(name: String, offset: Int?, limit: Int?) = marvelClient.call(
            path = "/characters",
            offset = offset,
            limit = limit,
            param = Pair("name", name))
}