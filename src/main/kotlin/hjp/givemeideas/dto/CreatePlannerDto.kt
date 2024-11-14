package hjp.givemeideas.dto


data class CreatePlannerDto(
    val title:String,
    val description:String,
    var check: Boolean = false,
)