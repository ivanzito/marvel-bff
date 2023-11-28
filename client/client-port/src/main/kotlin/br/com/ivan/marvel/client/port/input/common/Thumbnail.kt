package br.com.ivan.marvel.client.port.input.common

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MarvelThumbnail(
    val path: String?,
    val extension: String?
)
fun MarvelThumbnail.createUrl() = "$path.$extension"
