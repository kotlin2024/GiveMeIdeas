package hjp.givemeideas.model.today

import hjp.givemeideas.entity.PlannerToday
import hjp.givemeideas.entity.QPlannerToday.plannerToday
import hjp.givemeideas.infra.queryDsl.QueryDslSupport
import org.springframework.stereotype.Repository

import java.time.LocalDate

@Repository
class QueryDslPlannerRepository : CustomPlannerRepository, QueryDslSupport() {

    override fun findAllTodayPlanOnlyFalse(): List<PlannerToday> {
        val today = LocalDate.now()
        return queryFactory.selectFrom(plannerToday)
            .where(plannerToday.createdAt.eq(today))
            .where((plannerToday.check.isFalse))
            .limit(10) // 결과를 10개로 제한
            .fetch()
    }

    override fun findAllTodayPlanCount(): Double {
        val today = LocalDate.now()

        // 전체 개수
        val totalCount = queryFactory.selectFrom(plannerToday)
            .where(plannerToday.createdAt.eq(today))
            .fetch().size.toLong()

        // check = false인 항목 개수
        val falseCount = queryFactory.selectFrom(plannerToday)
            .where(
                plannerToday.createdAt.eq(today),
                plannerToday.check.isTrue
            )
            .fetch().size.toLong()


        return falseCount.toDouble() / totalCount.toDouble()
    }
}