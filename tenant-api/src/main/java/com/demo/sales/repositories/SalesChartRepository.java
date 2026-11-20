package com.demo.sales.repositories;

import com.demo.sales.constants.DbConstants;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalesChartRepository {

    // Top Cities chart: the ten cities with the most revenue in the selected period
    @Query(value = "SELECT s.city_nm, SUM(s.net_revenue_amt) AS revenue "
            + "FROM F_SALES_SUMMARY s "
            + "WHERE s.sale_dt BETWEEN :startDate AND :endDate"
            + DbConstants.FILTER_ACTIVE_REGION
            + "GROUP BY s.city_nm ORDER BY revenue DESC LIMIT 10", nativeQuery = true)
    List<Object[]> getTopCities(@Param("startDate") LocalDate startDate,
                                @Param("endDate") LocalDate endDate);

    // Revenue by Segment chart
    @Query(value = "SELECT s.customer_segment, SUM(s.net_revenue_amt) AS revenue, SUM(s.order_cnt) AS orders "
            + "FROM F_SALES_SUMMARY s "
            + "WHERE s.sale_dt BETWEEN :startDate AND :endDate"
            + DbConstants.FILTER_ACTIVE_REGION
            + "GROUP BY s.customer_segment ORDER BY revenue DESC", nativeQuery = true)
    List<Object[]> getRevenueBySegment(@Param("startDate") LocalDate startDate,
                                       @Param("endDate") LocalDate endDate);
}
