package br.com.ivan.marvel.client.port.input.common

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Urls(
    val type: String?,
    val url: String?
)