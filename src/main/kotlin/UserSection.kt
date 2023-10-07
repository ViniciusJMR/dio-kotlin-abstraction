class UserSection (
    val section: EducationalContent.Section,
) {

    private val userContents = section.contents.map { UserContent(it) }
    private var completed = false;

    fun complete(){
        completed = true
    }

    private fun userContentToString() = StringBuilder().let { builder ->
        userContents.forEach {
            builder.append("Content ${"-".repeat(30)}\n")
            builder.append("${it}\n")
        }
        builder
    }

    override fun toString() = """
name: ${section.name}
completed: $completed
contents: 
${userContentToString()}
    """.trimIndent()
}