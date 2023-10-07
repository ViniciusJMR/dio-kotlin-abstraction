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
        formation.contents.forEach { educationalContent ->
            builder.append("\t${"-".repeat(30)}\n")
            builder.append("\t${educationalContent}\n")
        }
        builder
    }

//    private fun contentToString() {
//        val buider = StringBuilder()
//        formation.contents.forEach {
//
//        }
//        formation.contents.map{"${"-".repeat(30)}\n${it}\n"}
//    }

    override fun toString() = """
name: ${formation.name}
level: ${formation.level}
duration: ${formation.totalDuration}
complete: $complete
contents: 
${contentToString()}
""".trimIndent()
}