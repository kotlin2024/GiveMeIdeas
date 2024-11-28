package hjp.givemeideas.model.week

import hjp.givemeideas.entity.PlannerWeek
import org.springframework.data.jpa.repository.JpaRepository

interface PlannerWeekRepository : JpaRepository<PlannerWeek, Long>