package br.com.ivan.marvel.client.port.dto.common

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MarvelItemDetail(
    @JsonProperty("resourceURI")
    val resource: String?,
    val name: String?,
    val type: String?
)
