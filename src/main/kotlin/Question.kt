data class Question<K, V>(
    val statement: String,
    val correct: K,
    val alternatives: Map<K, V>
) {

}