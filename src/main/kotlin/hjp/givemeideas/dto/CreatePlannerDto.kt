package hjp.givemeideas.dto


data class CreatePlannerDto(
    val description: String,
    var check: Boolean = false,
)