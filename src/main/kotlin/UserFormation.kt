data class UserFormation(
    val formation: Formation
) {

    private val userEducationalContents = formation.contents.map { UserEducationalContent(it) }
        get() = field

    private var complete = false
    fun completeFormation() {
        complete = true
    }

    private fun contentToString() = formation.contents.map{"${"-".repeat(30)}\n${it}\n"}

    override fun toString() = """
        
        name: ${formation.name}
        level: ${formation.level}
        duration ${formation.totalDuration}
        complete: $complete
        contents: 
            ${contentToString()}
            
    """.trimIndent()
}