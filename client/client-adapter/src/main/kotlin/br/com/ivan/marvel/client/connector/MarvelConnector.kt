package br.com.ivan.marvel.client.connector

import br.com.ivan.marvel.client.SecretManager
import br.com.ivan.marvel.client.config.MarvelConfigConnection
import org.springframework.stereotype.Service
import org.springframework.util.DigestUtils
import java.math.BigInteger
import java.sql.Timestamp
import java.time.Instant

@Service
class MarvelConnector(secretManager: SecretManager) {
    private val secret: MarvelConfigConnection = secretManager.getSecret()!!

    fun hash(): String {
        val ts: Long = Timestamp.from(Instant.now()).time
        val md5 = DigestUtils.md5Digest("${ts}${secret.privateKey}${secret.publicKey}".toByteArray())
        val hash = BigInteger(1, md5).toString(16)
        return "${secret.publicKey}&ts=${ts}&hash=${hash}"
    }
}