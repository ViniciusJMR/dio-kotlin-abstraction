import java.time.LocalDate

enum class Level { BASIC, INTERMEDIARY, ADVANCED }

data class User(
    var name: String,
    private val formations: MutableList<UserFormation> = mutableListOf(),
    private val educationalContents: MutableList<UserEducationalContent> = mutableListOf()
) {
    fun enroll(formation: Formation) {
        formations.add(UserFormation(formation = formation))
    }

    fun completeFormation(formation: Formation){
        formations
            .find { it.formation == formation }
            // Validate if every educational content is completed
            ?.completeFormation()
    }

    fun startEducationalContent(educationalContent: EducationalContent) {
        UserEducationalContent(educationalContent).also {
            educationalContents.add(it)
        }
    }

    fun completeEducationalContent(educationalContent: EducationalContent) {
        educationalContents
            .find { it.educationalContent == educationalContent }
            // Validate if every content is completed
            ?.completeEducationalContent()
    }

//    fun disenroll(formation: Formation) {
//        formations.add(formation)
//    }

}

data class UserFormation(
    val formation: Formation
) {
    private var complete = false
    fun completeFormation() {
        complete = true
    }
}

data class UserEducationalContent(
    val educationalContent: EducationalContent
) {
    private var complete = false
    fun completeEducationalContent() {
        complete = true
    }
}

// data class Content

// Each have videos and each video have category(?),
// Can have test
data class EducationalContent(
    var name: String,
    val duration: Int,
    val level: Level
)

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

fun main() {
//    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
//    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}