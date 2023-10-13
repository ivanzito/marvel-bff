package br.com.ivan.marvel.client.port.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Data(
    val offset: Float?,
    val limit: Float?,
    val total: Float?,
    val count: Float?,
    val results: Any?
)
