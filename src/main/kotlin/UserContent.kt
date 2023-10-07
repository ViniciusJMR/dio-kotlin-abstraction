class UserContent (
    val content: Content,
){
    private var completed: Boolean = false

    fun complete(){
        completed = true
    }

    override fun toString() = """
completed: $completed
$content
    """.trimIndent()
}