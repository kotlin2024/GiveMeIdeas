package hjp.givemeideas.controller

import hjp.givemeideas.dto.CreatePlannerDto
import hjp.givemeideas.dto.ToDoResponse
import hjp.givemeideas.service.PlannerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController("/planner")
class PlannerController(
    private val plannerService: PlannerService,
) {

    @PostMapping("/todo")
    fun createToDoToday(@RequestBody createPlannerDto: CreatePlannerDto): ResponseEntity<ToDoResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(plannerService.createToDoToday(createPlannerDto))
    }

//    @PostMapping
//    fun createToDoWeek(@RequestBody createPlannerDto: CreatePlannerDto){
//
//    }
//
//    @PostMapping
//    fun createToDoMonth(@RequestBody createPlannerDto: CreatePlannerDto){
//
//    }

    @DeleteMapping
    fun deleteToDo(){

    }

}