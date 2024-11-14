package hjp.givemeideas.model

import hjp.givemeideas.entity.Planner
import org.springframework.data.jpa.repository.JpaRepository

interface PlannerRepository : JpaRepository<Planner, Long> {
}