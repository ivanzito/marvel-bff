package br.com.ivan.marvel.client.port.input.character.list

import br.com.ivan.marvel.client.port.input.character.summary.StorySummary
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_NULL)
data class StoryList(
    val available: Int?,
    val returned: Int?,
    @JsonProperty("collectionURI")
    val collection: String?,
    val items: List<StorySummary>?
) : Serializable
