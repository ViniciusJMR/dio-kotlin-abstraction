data class UserEducationalContent(
    val educationalContent: EducationalContent
) {
    private var complete = false
    private val userSections = educationalContent.sections.map {
        UserSection(it)
    }

    fun completeEducationalContent() {
        complete = true
    }
}