package br.com.ivan.marvel.client

import br.com.ivan.marvel.client.port.input.character.CharacterDataWrapper
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths

class CharacterParseTest {
        @Test
        fun parsePayloadCharacters() {
                val path = javaClass.classLoader.getResource("characters-payload.json")?.path
                val payload = Files.readString(Paths.get(path!!))
                val characterDataWrapper = objectMapper().readValue(payload, CharacterDataWrapper::class.java)
                assertNotNull(characterDataWrapper)
                println(characterDataWrapper.data?.results?.first()?.comics)

        }

        @Test
        fun parsePayloadSingleCharacter() {
                val path = javaClass.classLoader.getResource("person-payload.json")?.path
                val payload = Files.readString(Paths.get(path!!))
                val marvelWrapper = objectMapper().readValue(payload, CharacterDataWrapper::class.java)
                assertNotNull(marvelWrapper)
        }

        private fun objectMapper() = ObjectMapper()
                .registerModules(
                        KotlinModule.Builder()
                                .withReflectionCacheSize(512)
                                .configure(KotlinFeature.NullToEmptyCollection, false)
                                .configure(KotlinFeature.NullToEmptyMap, false)
                                .configure(KotlinFeature.NullIsSameAsDefault, false)
                                .configure(KotlinFeature.SingletonSupport, false)
                                .configure(KotlinFeature.StrictNullChecks, false)
                                .build()
                ).registerModules(JavaTimeModule())
}