package hjp.givemeideas.dto

data class CreatePlannerMonthYearDto(
    val description: String,
    var check: Boolean = false,
    val type: String,
)
