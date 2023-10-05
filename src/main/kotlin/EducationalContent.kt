// data class Content

// Each have videos and each video have category(?),
// Can have test
data class EducationalContent(
    val name: String,
    val duration: Int,
    val level: Level,
    val sections: List<Section> = listOf()
) {
    data class Section(
        val name: String,
        val contents: List<Content>,
    )
}