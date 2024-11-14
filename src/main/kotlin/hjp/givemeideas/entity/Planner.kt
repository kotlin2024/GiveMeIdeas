package hjp.givemeideas.entity

import hjp.givemeideas.dto.ToDoResponse
import jakarta.persistence.*
import java.util.Date

@Entity(name = "planner")
class Planner(

    @Column(name = "제목")
    val title: String,

    @Column(name = "할일")
    val description: String,

    @Column(name = "작성일자")
    val createdAt: Date =Date(),

    @Column(name="완료여부")
    val check: Boolean = false

) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 1

}
fun Planner.toResponse(): ToDoResponse {
    return ToDoResponse(
        id = this.id,
        title = this.title,
        description = this.description,
        createdAt = this.createdAt,
        check = this.check
    )

}