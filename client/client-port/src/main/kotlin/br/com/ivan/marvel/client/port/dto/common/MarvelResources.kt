package br.com.ivan.marvel.client.port.dto.common

import com.fasterxml.jackson.annotation.JsonProperty

data class MarvelResources(
    val available: Int?,
    @JsonProperty("collectionURI")
    val collection: String?,
    val price: Double?,
    @JsonProperty("items")
    val creators: List<MarvelItems>?,
    val returned: Int?,
)