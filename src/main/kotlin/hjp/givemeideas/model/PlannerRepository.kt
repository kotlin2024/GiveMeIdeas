package hjp.givemeideas.model


import hjp.givemeideas.entity.PlannerToday
import hjp.givemeideas.entity.PlannerWeek
import org.springframework.data.jpa.repository.JpaRepository

interface PlannerTodayRepository : JpaRepository<PlannerToday, Long>

interface PlannerWeekRepository : JpaRepository<PlannerWeek, Long>