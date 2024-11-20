package hjp.givemeideas.service

//import hjp.givemeideas.model.PlannerWeekRepository
import hjp.givemeideas.dto.CreatePlannerDto
import hjp.givemeideas.dto.ToDoResponse
import hjp.givemeideas.entity.PlannerToday
import hjp.givemeideas.entity.PlannerWeek
import hjp.givemeideas.entity.toResponse
import hjp.givemeideas.model.today.PlannerTodayRepository
import hjp.givemeideas.model.today.QueryDslPlannerRepository
import hjp.givemeideas.model.week.PlannerWeekRepository
import hjp.givemeideas.model.week.QueryDslPlannerWeekRepository
import org.springframework.stereotype.Service

@Service
class PlannerService(
    private val plannerTodayRepository: PlannerTodayRepository,
    private val queryDslPlannerRepository: QueryDslPlannerRepository,
    private val plannerWeekRepository: PlannerWeekRepository,
    private val queryDslPlannerWeekRepository: QueryDslPlannerWeekRepository,
) {

    fun createToDoToday(dto: CreatePlannerDto): ToDoResponse {
        return plannerTodayRepository.save(
            PlannerToday(
                description = dto.description,
            )
        ).toResponse()
    }

    fun createToDoWeek(dto: CreatePlannerDto): ToDoResponse {
        return plannerWeekRepository.save(
            PlannerWeek(
                description = dto.description,
            )
        ).toResponse()
    }

    fun getTodayToDo(): List<ToDoResponse> {
        return queryDslPlannerRepository.findAllTodayPlan().map { it.toResponse() }
    }

    fun getWeekToDo(): List<ToDoResponse> {
        return queryDslPlannerWeekRepository.findAllWeekPlan().map { it.toResponse() }
    }
}