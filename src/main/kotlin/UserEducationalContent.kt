data class UserEducationalContent(
    val educationalContent: EducationalContent
) {
    private var complete = false
    fun completeEducationalContent() {
        complete = true
    }
}