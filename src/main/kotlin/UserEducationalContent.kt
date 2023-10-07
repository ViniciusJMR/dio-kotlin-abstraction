data class UserEducationalContent(
    val educationalContent: EducationalContent
) {
    private var complete = false
    private val userSections = educationalContent.sections.map { UserSection(it) }
        get() = field

    fun completeEducationalContent() {
        complete = true
    }

    private fun userSectionsToString() = StringBuilder().let { builder ->
        userSections.forEach {
            builder.append("Section ${"-".repeat(30)}\n")
            builder.append("${it}\n")
        }
        builder
    }

    override fun toString() = """
name: ${educationalContent.name}
duration: ${educationalContent.duration}
level: ${educationalContent.level}
sections: 
${userSectionsToString()}
    """.trimIndent()
}