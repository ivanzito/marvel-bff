package br.com.ivan.marvel.client

import br.com.ivan.marvel.client.config.MarvelConfigConnection
import br.com.ivan.marvel.client.connector.MarvelConnector
import br.com.ivan.marvel.client.port.input.character.CharacterDataWrapper
import br.com.ivan.marvel.client.port.input.character.toOutput
import br.com.ivan.marvel.client.port.output.CharacterResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service

@Service
class MarvelClient(
    private val marvelConnector: MarvelConnector,
    secretManager: SecretManager,
    private val json: ObjectMapper) {

    private val config = secretManager.getSecret()!!

    fun call(path: String,
                     identifier:String? = null,
                     offset: Int?,
                     limit: Int?,
                     param: Pair<String, String>): List<CharacterResponse> {

        return khttp.get(
            url = "${config.domain}/${path}${identifier ?: ""}",
            params = mapOf(
                "apikey" to marvelConnector.hash(),
                "offset" to "${offset ?: config.offset}",
                "limit" to "${limit ?: config.limit}",
                param.first to param.second
            ),
            headers = mapOf("Accept-Encoding" to "gzip")
        ).let {
            val response = json.readValue(it.text, CharacterDataWrapper::class.java)
            response
                .data?.
                results?.
                stream()?.
                map { it.toOutput() }?.
                toList() ?: listOf()
        }
    }

    fun call(path: String,
                     identifier:String? = null,
                     offset: Int?,
                     limit: Int?): List<CharacterResponse> {
        println("${config.domain}/${path}?apikey=${marvelConnector.hash()}")
        return khttp.get(
            url = "${config.domain}/${path}${identifier ?: ""}",
            params = mapOf(
                "apikey" to marvelConnector.hash(),
                "offset" to "${offset ?: config.offset}",
                "limit" to "${limit ?: config.limit}"
            ),
            headers = mapOf("Accept-Encoding" to "gzip")
        ).let { it ->
            val response = json.readValue(it.text, CharacterDataWrapper::class.java)
            response
                .data?.
                results?.
                stream()?.
                map { it.toOutput() }?.
                toList() ?: listOf()
        }
    }
}