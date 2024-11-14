package hjp.givemeideas.controller

import hjp.givemeideas.dto.CreatePlannerDto
import hjp.givemeideas.dto.ToDoResponse
import hjp.givemeideas.service.PlannerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController("/planner")
class PlannerController(
    private val plannerService: PlannerService,
) {

    @PostMapping("/todo")
    fun createToDoToday(@RequestBody dto: CreatePlannerDto): ResponseEntity<ToDoResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(plannerService.createToDoToday(dto))
    }

    @PostMapping("/todo/week")
    fun createToDoWeek(@RequestBody dto: CreatePlannerDto): ResponseEntity<ToDoResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(plannerService.createToDoWeek(dto))
    }


    @GetMapping("/planner/today")
    fun getToDoToday(): ResponseEntity<List<ToDoResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.getTodayToDo())
    }

    @GetMapping("/planner/week")
    fun getToDoWeek(): ResponseEntity<List<ToDoResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.getWeekToDo())

    }

    @GetMapping("/planner/month")
    fun getToDoMonth() {
        TODO()
    }

    @GetMapping("/planner/year")
    fun getToDoYear() {
        TODO()
    }

    @DeleteMapping
    fun deleteToDo() {
        TODO()
    }

}