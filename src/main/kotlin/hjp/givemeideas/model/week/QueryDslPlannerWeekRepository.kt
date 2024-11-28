package hjp.givemeideas.model.week

import hjp.givemeideas.entity.PlannerWeek
import hjp.givemeideas.entity.QPlannerWeek.plannerWeek
import hjp.givemeideas.infra.queryDsl.QueryDslSupport
import org.springframework.stereotype.Repository
import java.time.DayOfWeek
import java.time.LocalDate

@Repository
class QueryDslPlannerWeekRepository : QueryDslSupport() {

    fun findAllWeekPlanOnlyFalse(): List<PlannerWeek> {
        val today = LocalDate.now()
        val startOfWeek = today.with(DayOfWeek.MONDAY) // 이번 주 월요일
        val endOfWeek = today.with(DayOfWeek.SUNDAY) // 이번 주 일요일

        return queryFactory.selectFrom(plannerWeek)
            .where(
                plannerWeek.createdAt.between(startOfWeek, endOfWeek) // 날짜 범위 조건
            )
            .where((plannerWeek.check.isFalse))
            .fetch()
    }

    fun findAllWeekPlanCount(): Double {
        val today = LocalDate.now()
        val startOfWeek = today.with(DayOfWeek.MONDAY) // 이번 주 월요일
        val endOfWeek = today.with(DayOfWeek.SUNDAY)
        // 전체 개수
        val totalCount = queryFactory.selectFrom(plannerWeek)
            .where(plannerWeek.createdAt.between(startOfWeek, endOfWeek))
            .fetch().size.toLong()

        // check = false인 항목 개수
        val falseCount = queryFactory.selectFrom(plannerWeek)
            .where(
                plannerWeek.createdAt.between(startOfWeek, endOfWeek),
                plannerWeek.check.isTrue
            )
            .fetch().size.toLong()

        return falseCount.toDouble() / totalCount.toDouble()
    }
}