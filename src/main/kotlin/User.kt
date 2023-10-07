data class User(
    var name: String
) {
    private val formations: MutableList<UserFormation> = mutableListOf()
        get() = field
    fun enroll(formation: Formation) {
        formations.add(UserFormation(formation = formation))
    }

    fun completeFormation(formation: Formation){
        formations
            .find { it.formation == formation }
            // Validate if every educational content is completed
            ?.completeFormation()
    }

    fun disenroll(formation: Formation){
        formations.removeIf { it.formation == formation }
    }

    private fun formationToString() = StringBuilder().let { builder ->
        formations.forEach { formation ->
            builder.append("${"-".repeat(30)}\n")
            builder.append("${formation}\n")
        }
        builder
    }

    override fun toString() = """
name: $name
formations:
${formationToString()}
    """.trimIndent()


}