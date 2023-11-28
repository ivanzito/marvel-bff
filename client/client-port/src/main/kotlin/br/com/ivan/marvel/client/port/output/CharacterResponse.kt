package br.com.ivan.marvel.client.port.output

import br.com.ivan.marvel.client.port.input.character.summary.ComicSummary
import br.com.ivan.marvel.client.port.input.character.summary.EventSummary
import br.com.ivan.marvel.client.port.input.character.summary.SeriesSummary
import br.com.ivan.marvel.client.port.input.character.summary.StorySummary
import br.com.ivan.marvel.client.port.input.common.Urls
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CharacterResponse(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val modified: String? = null,
    val thumbnail: String? = null,
    @JsonProperty("resourceURI")
    val resource: String? = null,
    val comics: List<ComicSummary>? = null,
    val events: List<EventSummary>? = null,
    val series: List<SeriesSummary>? = null,
    val stories: List<StorySummary>? = null,
    val urls: List<Urls>?)
