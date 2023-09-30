import java.time.LocalDate

data class Formation(
    val nome: String,
    val level: Level,
    var dueDate: LocalDate,
    val contents: MutableList<EducationalContent> = mutableListOf(),
) {
    val totalDuration = calculateTotalDuration()
    private val subscribers = mutableListOf<User>()

    fun enroll(user: User) {
//        subscribers.addAll(users.asList())
        subscribers.add(user)
        // Create upper class to handle this
//        users.forEach {
//            it.enroll(this)
//        }
    }

    private fun calculateTotalDuration() = contents
        .map { it.duration }
        .fold(0) { acc, next -> acc + next }
}