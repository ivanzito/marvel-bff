package br.com.ivan.marvel.client.port.dto.common

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MarvelThumbnail(
    val path: String?,
    val extension: String?
) {
    fun MarvelThumbnail.createUrl() = this.path + "." + extension
}
