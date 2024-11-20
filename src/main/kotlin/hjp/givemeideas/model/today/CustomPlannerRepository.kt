package hjp.givemeideas.model.today

import hjp.givemeideas.entity.PlannerToday

interface CustomPlannerRepository {

    fun findAllTodayPlan(): List<PlannerToday>

}