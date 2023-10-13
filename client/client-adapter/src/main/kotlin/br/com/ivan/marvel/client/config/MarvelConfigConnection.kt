package br.com.ivan.marvel.client.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@ConfigurationProperties(prefix = "marvel")
data class MarvelConfigConnection(
    var publicKey: String = "",
    var privateKey: String = "",
    var domain: String = "")

//@Configuration
//open class AppConfiguration {
//    @Bean open fun apiConfiguration() = MarvelConfigConnection()
//}
