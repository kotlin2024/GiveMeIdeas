package hjp.givemeideas.model.today

import hjp.givemeideas.entity.PlannerToday

interface CustomPlannerRepository {

    fun findAllTodayPlanOnlyFalse(): List<PlannerToday>

    fun findAllTodayPlanCount(): Double
}