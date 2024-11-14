package hjp.givemeideas.service

import hjp.givemeideas.dto.CreatePlannerDto
import hjp.givemeideas.dto.ToDoResponse
import hjp.givemeideas.entity.PlannerToday
import hjp.givemeideas.entity.PlannerWeek
import hjp.givemeideas.entity.toResponse
import hjp.givemeideas.model.PlannerTodayRepository
import hjp.givemeideas.model.PlannerWeekRepository
import org.springframework.stereotype.Service

@Service
class PlannerService(
    private val plannerTodayRepository: PlannerTodayRepository,
    private val plannerWeekRepository: PlannerWeekRepository
) {

    fun createToDoToday(dto: CreatePlannerDto): ToDoResponse {
        return plannerTodayRepository.save(
            PlannerToday(
                description = dto.description,
            )
        ).toResponse()
    } //TODO 날짜 비교해서 오늘날짜만 조회하도록 해야함

    fun createToDoWeek(dto: CreatePlannerDto): ToDoResponse {
        return plannerWeekRepository.save(
            PlannerWeek(
                description = dto.description,
            )
        ).toResponse()
    } //TODO() 날짜 비교해서 해당주에 해당하는 날짜의 할일들만 조회하도록 해야함

    fun getTodayToDo(): List<ToDoResponse> {
        return plannerTodayRepository.findAll().map { it.toResponse() }
    }

    fun getWeekToDo(): List<ToDoResponse> {
        return plannerWeekRepository.findAll().map { it.toResponse() }
    }
}