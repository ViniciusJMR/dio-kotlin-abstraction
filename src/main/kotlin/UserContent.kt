class UserContent (
    val content: Content,
){
    private var completed: Boolean = false

    fun complete(){
        completed = true
    }
}