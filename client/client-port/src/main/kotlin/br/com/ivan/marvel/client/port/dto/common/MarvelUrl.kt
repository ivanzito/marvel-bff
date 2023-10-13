package br.com.ivan.marvel.client.port.dto.common

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MarvelUrl(
    val type: String?,
    val url: String?
)