package br.com.ivan.marvel.client

import br.com.ivan.marvel.client.connector.MarvelConnector
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class MarvelClient(
    private val marvelConnector: MarvelConnector,
    @Value("\${marvel.domain}")
    private val domain: String) {

    fun url(path: String, pathVariable: Pair<String, String>) =
        "$domain$path${marvelConnector.hash()}&${pathVariable.first}=${pathVariable.second}"
    fun url(path: String, id: String, detail: String) =
        "$domain$path/$id$detail${marvelConnector.hash()}".also { println(it) }
    fun url(path: String, id: String) =
        "$domain$path/$id${marvelConnector.hash()}".also { println(it) }
    fun url(path: String) =
        "$domain$path${marvelConnector.hash()}".also { println(it) }
}