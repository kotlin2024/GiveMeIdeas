package hjp.givemeideas.model


import hjp.givemeideas.entity.PlannerToday
import org.springframework.data.jpa.repository.JpaRepository

interface PlannerTodayRepository : JpaRepository<PlannerToday, Long>