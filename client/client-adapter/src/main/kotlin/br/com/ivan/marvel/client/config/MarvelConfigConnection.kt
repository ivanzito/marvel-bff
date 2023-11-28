package br.com.ivan.marvel.client.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "marvel")
data class MarvelConfigConnection(
    var publicKey: String = "",
    var privateKey: String = "",
    var domain: String = "",
    var offset: Int = 0,
    var limit: Int = 20)
