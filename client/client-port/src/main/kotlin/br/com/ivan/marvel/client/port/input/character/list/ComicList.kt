package br.com.ivan.marvel.client.port.input.character.list

import br.com.ivan.marvel.client.port.input.character.summary.ComicSummary
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ComicList(
    val available: Int,
    @JsonProperty("collectionURI")
    val collection: String,
    val returned: Int,
    val items: List<ComicSummary>) : Serializable


