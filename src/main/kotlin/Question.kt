data class Question(
    val statement: String,
    val correct: String,
    val alternatives: Map<String, String>
) {

}