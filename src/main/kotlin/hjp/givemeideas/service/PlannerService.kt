package hjp.givemeideas.service

import hjp.givemeideas.dto.CreatePlannerDto
import hjp.givemeideas.dto.ToDoResponse
import hjp.givemeideas.entity.Planner
import hjp.givemeideas.entity.toResponse
import hjp.givemeideas.model.PlannerRepository
import org.springframework.stereotype.Service

@Service
class PlannerService(
    private val plannerRepository: PlannerRepository,
) {

    fun createToDoToday(dto:CreatePlannerDto):ToDoResponse{
        return plannerRepository.save(
            Planner(
                title = dto.title,
                description = dto.description,
            )
        ).toResponse()

    }
}