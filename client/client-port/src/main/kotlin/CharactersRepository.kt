import br.com.ivan.marvel.client.port.dto.MarvelWrapper

interface CharactersRepository {
    fun characters():MarvelWrapper
    fun character(id: String):MarvelWrapper
    fun characterStartsWith(name: String):MarvelWrapper
    fun characterByName(name: String):MarvelWrapper
    fun stories(id: String):MarvelWrapper
    fun series(id: String):MarvelWrapper
    fun comics(id: String):MarvelWrapper
    fun events(id: String):MarvelWrapper
}