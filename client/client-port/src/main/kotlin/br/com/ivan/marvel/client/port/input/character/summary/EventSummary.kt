package br.com.ivan.marvel.client.port.input.character.summary

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_NULL)
data class EventSummary(
    @JsonProperty("resourceURI")
    val resource: String? = null,
    val name: String? = null) : Serializable