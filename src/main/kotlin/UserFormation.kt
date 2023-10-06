data class UserFormation(
    val formation: Formation
) {

    private val userEducationalContents = formation.contents.map { UserEducationalContent(it) }
        get() = field

    private var complete = false
    fun completeFormation() {
        complete = true
    }
}