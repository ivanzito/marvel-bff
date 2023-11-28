package br.com.ivan.marvel.client.port.input.character.list

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import br.com.ivan.marvel.client.port.input.character.summary.SeriesSummary
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SeriesList(
    val available: Int?,
    val returned: Int?,
    @JsonProperty("collectionURI")
    val collection: String?,
    val items: List<SeriesSummary>?) : Serializable
