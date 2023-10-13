package br.com.ivan.marvel.client.connector

import br.com.ivan.marvel.client.config.MarvelConfigConnection
import org.springframework.stereotype.Service
import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.sql.Timestamp
import java.time.Instant

@Service
class MarvelConnector(private val marvelConfigConnection: MarvelConfigConnection) {

    fun hash(): String {
        val ts: Long = Timestamp.from(Instant.now()).time
        val md5: MessageDigest = MessageDigest.getInstance("MD5")
        val md5Digest = md5.digest("${ts}${marvelConfigConnection.privateKey}${marvelConfigConnection.publicKey}".toByteArray(StandardCharsets.UTF_8))
        val hash = BigInteger(1, md5Digest).toString(16)
        return "?apikey=${marvelConfigConnection.publicKey}&ts=${ts}&hash=${hash}"
    }
}