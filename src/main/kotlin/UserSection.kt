class UserSection (
    val section: EducationalContent.Section,
) {
    private var completed = false;

    fun complete(){
        completed = true
    }
}