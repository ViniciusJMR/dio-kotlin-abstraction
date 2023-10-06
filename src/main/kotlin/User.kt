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

    override fun toString() = """
        
        name: $name
        formations:
            $formations
            
    """.trimIndent()


}