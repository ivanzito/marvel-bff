package br.com.ivan.marvel

import br.com.ivan.marvel.client.config.MarvelConfigConnection
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(MarvelConfigConnection::class)
open class Startup

    fun main(args: Array<String>) {
        runApplication<Startup>(*args);
    }