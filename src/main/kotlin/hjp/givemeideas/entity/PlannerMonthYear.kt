package hjp.givemeideas.entity

import hjp.givemeideas.dto.ToDoResponse
import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "planner_month_year")
class PlannerMonthYear(

    @Column(name = "오늘의 할일")
    val description: String,

    @Column(name = "작성일자")
    val createdAt: LocalDate = LocalDate.now(),

    @Column(name = "완료여부")
    var check: Boolean = false,

    @Column(name = "type")
    val type: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}

fun PlannerMonthYear.toResponse(): ToDoResponse {
    return ToDoResponse(
        id = this.id!!,
        description = this.description,
        createdAt = this.createdAt,
        check = this.check,
    )
}