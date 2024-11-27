package hjp.givemeideas.service

//import hjp.givemeideas.model.PlannerWeekRepository
import hjp.givemeideas.dto.CheckingDto
import hjp.givemeideas.dto.CreatePlannerDto
import hjp.givemeideas.dto.CreatePlannerMonthYearDto
import hjp.givemeideas.dto.ToDoResponse
import hjp.givemeideas.entity.PlannerMonthYear
import hjp.givemeideas.entity.PlannerToday
import hjp.givemeideas.entity.PlannerWeek
import hjp.givemeideas.entity.toResponse
import hjp.givemeideas.model.monthyear.PlannerMonthYearRepository
import hjp.givemeideas.model.monthyear.QueryDslMonthYear
import hjp.givemeideas.model.today.PlannerTodayRepository
import hjp.givemeideas.model.today.QueryDslPlannerRepository
import hjp.givemeideas.model.week.PlannerWeekRepository
import hjp.givemeideas.model.week.QueryDslPlannerWeekRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlannerService(
    private val plannerTodayRepository: PlannerTodayRepository,
    private val queryDslPlannerRepository: QueryDslPlannerRepository,
    private val plannerWeekRepository: PlannerWeekRepository,
    private val queryDslPlannerWeekRepository: QueryDslPlannerWeekRepository,
    private val plannerMonthYearRepository: PlannerMonthYearRepository,
    private val queryDslMonthYear: QueryDslMonthYear,

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

    fun createToDoMonthYear(dto: CreatePlannerMonthYearDto): ToDoResponse {
        if (dto.type.uppercase(Locale.getDefault()) == "MONTH") {
            return plannerMonthYearRepository.save(
                PlannerMonthYear(
                    description = dto.description,
                    type = "MONTH"
                )
            ).toResponse()
        } else {
            return plannerMonthYearRepository.save(
                PlannerMonthYear(
                    description = dto.description,
                    type = "YEAR"
                )
            ).toResponse()
        }
    }

    fun getTodayToDo(): List<ToDoResponse> {
        return queryDslPlannerRepository.findAllTodayPlan().map { it.toResponse() }
    }

    fun getWeekToDo(): List<ToDoResponse> {
        return queryDslPlannerWeekRepository.findAllWeekPlan().map { it.toResponse() }
    }

    fun getMonthYearToDo(type: String): List<ToDoResponse> {

        return if (type.uppercase() == "MONTH")
            queryDslMonthYear.findAllMonthPlan().map { it.toResponse() }
        else
            queryDslMonthYear.findAllYearPlan().map { it.toResponse() }
    }

    fun checkTodoToday(dto: List<CheckingDto>): List<ToDoResponse> {
        val checkingPlans = plannerTodayRepository.findAllById(dto.map { it.id })

        val updatedPlans = checkingPlans.map { plan ->
            val checkDto = dto.find { it.id == plan.id }
            if (checkDto != null) {
                plan.check = checkDto.check  // 체크 상태 업데이트
            }
            plannerTodayRepository.save(plan)
        }
        return updatedPlans.map { it.toResponse() }
    }

    fun checkTodoWeek(dto: List<CheckingDto>): List<ToDoResponse> {
        val checkingPlans = plannerWeekRepository.findAllById(dto.map { it.id })

        val updatedPlans = checkingPlans.map { plan ->
            val checkDto = dto.find { it.id == plan.id }
            if (checkDto != null) {
                plan.check = checkDto.check  // 체크 상태 업데이트
            }
            plannerWeekRepository.save(plan)
        }
        return updatedPlans.map { it.toResponse() }
    }

    fun checkTodoMonthYear(dto: List<CheckingDto>): List<ToDoResponse> {

        val checkingPlans = plannerMonthYearRepository.findAllById(dto.map { it.id })
        val updatedPlans = checkingPlans.map { plan ->
            val checkDto = dto.find { it.id == plan.id }
            if (checkDto != null) {
                plan.check = checkDto.check  // 체크 상태 업데이트
            }
            plannerMonthYearRepository.save(plan)
        }
        return updatedPlans.map { it.toResponse() }

    }
}