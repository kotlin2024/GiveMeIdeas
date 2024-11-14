package hjp.givemeideas.dto

import java.time.LocalDate

data class ToDoResponse(
    val id: Long,
    val description: String,
    val check: Boolean,
    val createdAt: LocalDate,
)
