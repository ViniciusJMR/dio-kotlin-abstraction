sealed class Content(
    open val name: String
) {
    data class Video(override val name: String, val url: String): Content(name)
    data class Document(override val name: String, val text: String): Content(name)
    data class Test<K, V>(override val name: String, val questions: List<Question<K, V>>): Content(name)
}

