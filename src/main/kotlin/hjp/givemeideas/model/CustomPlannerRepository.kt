package hjp.givemeideas.model

import hjp.givemeideas.entity.PlannerToday

interface CustomPlannerRepository {

    fun findAllTodayPlan(): List<PlannerToday>
}