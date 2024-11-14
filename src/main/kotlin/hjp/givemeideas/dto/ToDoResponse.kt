package hjp.givemeideas.dto

import java.util.*

data class ToDoResponse(
    val id: Long,
    val title: String,
    val description: String,
    val check: Boolean,
    val createdAt: Date,
)
