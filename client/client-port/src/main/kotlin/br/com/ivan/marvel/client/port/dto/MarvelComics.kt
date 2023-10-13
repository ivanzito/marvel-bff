package br.com.ivan.marvel.client.port.dto

import br.com.ivan.marvel.client.port.dto.common.MarvelResources
import br.com.ivan.marvel.client.port.dto.common.MarvelThumbnail
import br.com.ivan.marvel.client.port.dto.common.MarvelUrl
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MarvelComics (
    val id:Long?,
    val digitalId: Long?,
    val title: String?,
    val issueNumber: Int?,
    val variantDescription: String?,
    val description: String?,
    val modified: LocalDateTime?,
    val isbn: String?,
    val upc: String?,
    val diamondCode: String?,
    val ean: String?,
    val issn: String?,
    val format: String?,
    val pageCount: Int?,
    val textObjects: List<TextObjects>,
    @JsonProperty("resourceURI")
    val resources: String?,
    val urls: List<MarvelUrl>?,
    val series: Map<String, MarvelUrl>,
    val variants: List<Any>?,
    val collections: List<Any>,
    val collectedIssues: List<Any>,
    val dates: Map<String, LocalDateTime>,
    val prices: Map<String, Double>?,
    val thumbnail: MarvelThumbnail?,
    val images: List<MarvelThumbnail>?,
    val comics: MarvelResources?,
    val stories: MarvelResources?,
    val events: MarvelResources?,
)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TextObjects(
    val type: String?,
    val language: String?,
    val text: String?
)
