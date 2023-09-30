data class UserFormation(
    val formation: Formation
) {
    private var complete = false
    fun completeFormation() {
        complete = true
    }
}