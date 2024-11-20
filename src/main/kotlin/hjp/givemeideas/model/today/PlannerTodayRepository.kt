package hjp.givemeideas.model.today


import hjp.givemeideas.entity.PlannerToday
import org.springframework.data.jpa.repository.JpaRepository

interface PlannerTodayRepository : JpaRepository<PlannerToday, Long>

