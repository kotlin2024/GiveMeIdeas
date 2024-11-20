package hjp.givemeideas.entity

import hjp.givemeideas.dto.ToDoResponse
import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "plannerWeek")
class PlannerWeek(
    @Column(name = "주간 할일")
    val description: String,

    @Column(name = "완료 여부")
    val check: Boolean = false,

    @Column(name = "생성일")
    val createdAt: LocalDate = LocalDate.now()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun PlannerWeek.toResponse(): ToDoResponse {
    return ToDoResponse(
        id = this.id!!,
        description = this.description,
        check = this.check,
        createdAt = this.createdAt
    )
}