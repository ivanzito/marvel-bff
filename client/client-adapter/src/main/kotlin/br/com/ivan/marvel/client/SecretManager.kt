package br.com.ivan.marvel.client

import br.com.ivan.marvel.client.config.MarvelConfigConnection
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse

@Component
class SecretManager(private val objectMapper: ObjectMapper) {
    fun getSecret(): MarvelConfigConnection? {
        val secretName = "marvel-secret-manager"
        val region: Region = Region.of("us-east-1")

        // Create a Secrets Manager client
        val client = SecretsManagerClient.builder()
            .region(region)
            .build()
        val getSecretValueRequest = GetSecretValueRequest.builder()
            .secretId(secretName)
            .build()
        val getSecretValueResponse: GetSecretValueResponse = try {
            client.getSecretValue(getSecretValueRequest)
        } catch (e: Exception) {
            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
            throw e
        }
        val secret = getSecretValueResponse.secretString()

        return objectMapper.readValue(secret, MarvelConfigConnection::class.java)
    }
}