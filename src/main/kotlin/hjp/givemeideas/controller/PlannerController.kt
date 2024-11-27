package hjp.givemeideas.controller

import hjp.givemeideas.dto.CheckingDto
import hjp.givemeideas.dto.CreatePlannerDto
import hjp.givemeideas.dto.CreatePlannerMonthYearDto
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

    @PostMapping("/todo/month_year")
    fun createToDoMonthYear(@RequestBody dto: CreatePlannerMonthYearDto): ResponseEntity<ToDoResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(plannerService.createToDoMonthYear(dto))
    }


    @GetMapping("/planner/today")
    fun getToDoToday(): ResponseEntity<List<ToDoResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.getTodayToDo())
    }

    @GetMapping("/planner/week")
    fun getToDoWeek(): ResponseEntity<List<ToDoResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.getWeekToDo())

    }

    @GetMapping("/planner/month_year")
    fun getToDoMonthYear(@RequestParam type: String): ResponseEntity<List<ToDoResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.getMonthYearToDo(type))
    }

    @PatchMapping("/planner/check/today")
    fun checkTodoToday(@RequestBody dto: List<CheckingDto>): ResponseEntity<List<ToDoResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.checkTodoToday(dto))
    }

    @PatchMapping("/planner/check/week")
    fun checkTodoWeek(@RequestBody dto: CheckingDto): ResponseEntity<ToDoResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(plannerService.checkTodoWeek(dto))

    }

    @DeleteMapping
    fun deleteToDo() {
        TODO()
    }

}