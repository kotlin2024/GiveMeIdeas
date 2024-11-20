package hjp.givemeideas.model.week

import hjp.givemeideas.entity.PlannerWeek
import hjp.givemeideas.entity.QPlannerWeek.plannerWeek
import hjp.givemeideas.infra.queryDsl.QueryDslSupport
import org.springframework.stereotype.Repository
import java.time.DayOfWeek
import java.time.LocalDate

@Repository
class QueryDslPlannerWeekRepository : QueryDslSupport() {

    fun findAllWeekPlan(): List<PlannerWeek> {
        val today = LocalDate.now()
        val startOfWeek = today.with(DayOfWeek.MONDAY) // 이번 주 월요일
        val endOfWeek = today.with(DayOfWeek.SUNDAY) // 이번 주 일요일

        return queryFactory.selectFrom(plannerWeek)
            .where(
                plannerWeek.createdAt.between(startOfWeek, endOfWeek) // 날짜 범위 조건
            )
            .fetch()
    }
}