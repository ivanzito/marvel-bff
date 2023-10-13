package br.com.ivan.marvel.client.port.dto

import br.com.ivan.marvel.client.port.dto.common.MarvelResources
import br.com.ivan.marvel.client.port.dto.common.MarvelThumbnail
import br.com.ivan.marvel.client.port.dto.common.MarvelUrl
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MarvelCharacters(
    val id: Float?,
    val name: String?,
    val description: String?,
    val modified: String?,
    val thumbnail: MarvelThumbnail?,
    @JsonProperty("resourceURI")
    val resource: String?,
    val comics: MarvelResources?,
    val series: MarvelResources?,
    val stories: MarvelResources?,
    val events: MarvelResources?,
    val url: List<MarvelUrl>?
)