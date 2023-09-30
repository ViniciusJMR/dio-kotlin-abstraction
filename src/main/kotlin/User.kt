data class User(
    var name: String,
    private val formations: MutableList<UserFormation> = mutableListOf(),
    private val educationalContents: MutableList<UserEducationalContent> = mutableListOf()
) {
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

    fun startEducationalContent(educationalContent: EducationalContent) {
        UserEducationalContent(educationalContent).also {
            educationalContents.add(it)
        }
    }

    fun completeEducationalContent(educationalContent: EducationalContent) {
        educationalContents
            .find { it.educationalContent == educationalContent }
            // Validate if every content is completed
            ?.completeEducationalContent()
    }

//    fun disenroll(formation: Formation) {
//        formations.add(formation)
//    }

}