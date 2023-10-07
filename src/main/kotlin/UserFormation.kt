data class UserFormation(
    val formation: Formation
) {

    private val userEducationalContents = formation.contents.map { UserEducationalContent(it) }
        get() = field

    private var complete = false
    fun completeFormation() {
        complete = true
    }

    private fun contentToString() = StringBuilder().let { builder ->
        userEducationalContents.forEach { educationalContent ->
            builder.append("Educational Contents ${"-".repeat(30)}\n")
            builder.append("${educationalContent}\n")
        }
        builder
    }


    override fun toString() = """
name: ${formation.name}
level: ${formation.level}
duration: ${formation.totalDuration}
complete: $complete
contents: 
${contentToString()}
""".trimIndent()
}