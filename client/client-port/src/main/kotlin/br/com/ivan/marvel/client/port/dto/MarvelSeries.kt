package br.com.ivan.marvel.client.port.dto

import br.com.ivan.marvel.client.port.dto.common.MarvelResources
import br.com.ivan.marvel.client.port.dto.common.MarvelThumbnail
import br.com.ivan.marvel.client.port.dto.common.MarvelUrl
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MarvelSeries(
    val id: Int?,
    val title: String?,
    val description: String?,
    @JsonProperty("resourceURI")
    val resource: String?,
    val urls: List<MarvelUrl>?,
    val startYear: Int?,
    val endYear: Int?,
    val rating: String?,
    val type: String?,
    val modified: LocalDateTime?,
    val thumbnail: MarvelThumbnail?,
    val creators: MarvelResources?,
    val characters: MarvelResources?,
    val stories: MarvelResources?,
    val comics: MarvelResources?,
    val events: MarvelResources?,
    //val next: MarvelUrl
    //val previous: MarvelUrl
)
