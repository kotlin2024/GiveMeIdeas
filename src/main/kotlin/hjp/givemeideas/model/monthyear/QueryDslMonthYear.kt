package hjp.givemeideas.model.monthyear

import hjp.givemeideas.entity.PlannerMonthYear
import hjp.givemeideas.entity.QPlannerMonthYear
import hjp.givemeideas.infra.queryDsl.QueryDslSupport
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class QueryDslMonthYear : QueryDslSupport() {

    private val planner = QPlannerMonthYear.plannerMonthYear

    fun findAllMonthPlan(): List<PlannerMonthYear> {
        val startDate = LocalDate.now().withDayOfMonth(1) // 이번 달 첫째 날
        val endDate = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()) // 이번 달 마지막 날

        return queryFactory.selectFrom(planner)
            .where(
                planner.type.eq("MONTH"),
                planner.createdAt.between(startDate, endDate)
            )
            .fetch()
    }

    fun findAllYearPlan(): List<PlannerMonthYear> {
        val startDate = LocalDate.now().withDayOfYear(1) // 이번 연도의 첫째 날
        val endDate = LocalDate.now().withDayOfYear(LocalDate.now().lengthOfYear()) // 이번 연도의 마지막 날

        return queryFactory.selectFrom(planner)
            .where(
                planner.type.eq("YEAR"),
                planner.createdAt.between(startDate, endDate)
            )
            .fetch()
    }

}