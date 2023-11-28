package br.com.ivan.marvel.client.port.input.character

import br.com.ivan.marvel.client.port.input.common.MarvelThumbnail
import br.com.ivan.marvel.client.port.input.common.Urls
import br.com.ivan.marvel.client.port.input.character.list.ComicList
import br.com.ivan.marvel.client.port.input.character.list.EventList
import br.com.ivan.marvel.client.port.input.character.list.SeriesList
import br.com.ivan.marvel.client.port.input.character.list.StoryList
import br.com.ivan.marvel.client.port.input.common.createUrl
import br.com.ivan.marvel.client.port.output.CharacterResponse
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Character(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val modified: String? = null,
    val thumbnail: MarvelThumbnail? = null,
    @JsonProperty("resourceURI")
    val resource: String? = null,
    val comics: ComicList? = null,
    val series: SeriesList? = null,
    val stories: StoryList? = null,
    val events: EventList? = null,
    val urls: List<Urls>? = null
)

fun Character.toOutput() = CharacterResponse(
    id = this.id,
    name = this.name,
    description = this.description,
    modified = this.modified,
    thumbnail = this.thumbnail?.createUrl(),
    resource = this.resource,
    comics = this.comics?.items,
    events = this.events?.items,
    series = this.series?.items,
    stories = this.stories?.items,
    urls = this.urls)
