package com.mshelper.dms.dao.ext;

import com.mshelper.dms.po.FuncHits;
import com.mshelper.dms.vo.FunctionUsageDetail;
import com.mshelper.dms.vo.SubtotalWithinTimeUnit;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Stand Alone Where Clauses
 * 独立的where字句，用于一些无法使用该库中方法解决的特殊查询
 *
 * @author Bellamy
 */

@Repository
@Mapper
public interface FuncHitsExtMapper {

    /**
     * 查询指定月的所有记录
     *
     * @param funcId
     * @param month
     * @return
     */
//    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @Select({
            "select ht_id, ht_fc_id, ht_date, ht_usr_id ",
            "from func_hits ",
            "where ht_fc_id = #{funcId} and date_format(ht_date, '%Y-%m') = #{month} "
//            "order by id",
//            "OFFSET #{offset,jdbcType=INTEGER} LIMIT #{limit,jdbcType=INTEGER}"
    })
    @Results(id = "FuncHitsResult", value = {
            @Result(column = "ht_id", property = "htId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "ht_fc_id", property = "htFcId", jdbcType = JdbcType.BIGINT),
            @Result(column = "ht_date", property = "htDate", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "ht_usr_id", property = "htUsrId", jdbcType = JdbcType.BIGINT)
    })
    List<FuncHits> selectByFuncIdAndMonth(@Param("funcId") Long funcId, @Param("month") String month);


    /**
     * 查询指定功能 在指定时间段内的所有记录
     *
     * @param funcId
     * @param startDate
     * @param endDate
     * @return
     */
    @Select({
            "select ht_id, ht_fc_id, ht_date, ht_usr_id ",
            "from func_hits ",
            "where ht_fc_id = #{funcId} and date_format(ht_date, '%Y-%m-%d') ",
            "between date_format(#{startDate}, '%Y-%m-%d')  and date_format(#{endDate}, '%Y-%m-%d')"
    })
    @ResultMap("FuncHitsResult")
    List<FuncHits> selectByFuncIdAndInterval(@Param("funcId") Long funcId,
                                             @Param("startDate") String startDate,
                                             @Param("endDate") String endDate);


    /**
     * 查询指定功能在指定年份 每月的使用使用量
     *
     * @param funcId
     * @param year
     * @return
     */
    @Select({
            "select MONTH(ht_date) as timeUnit, COUNT(1) as subtotal ",
            "from func_hits ",
            "where ht_fc_id = #{funcId}  ",
            "and date_format(ht_date, '%Y') = #{year}",
            "group by MONTH(ht_date)"

    })
    @Results(id = "SubtotalWithinTimeUnitResult", value = {
            @Result(column = "timeUnit", property = "timeUnit"),
            @Result(column = "subtotal", property = "subtotal")
    })
    List<SubtotalWithinTimeUnit> selectByFuncIdGroupByMonth(@Param("funcId") Long funcId, @Param("year") String year);

    /**
     * 根据指定的时间单位来查找该单位下 各个 次单位时间内 的功能使用量
     *
     * @param funcId
     * @param timeUnit 时间单位 pattern   年 %Y   or  月 %Y-%m  or 周 %Y-%m-%u  or 日 %Y-%m-%d  ...
     *                 pattern ： https://www.w3school.com.cn/sql/func_date_format.asp
     * @return
     */
    @Select({
            "select date_format(ht_date, #{timeUnit}) as timeUnit, COUNT(1) as subtotal ",
            "from func_hits ",
            "where ht_fc_id = #{funcId} ",
            "group by timeUnit "
    })
    @ResultMap("SubtotalWithinTimeUnitResult")
    List<SubtotalWithinTimeUnit> selectByFuncIdGroupByTimeUnit(@Param("funcId") Long funcId, @Param("timeUnit") String timeUnit);

    /**
     * 根据指定日期查找 被使用过的功能的 功能名 及其 使用量 （不包含未被使用过的功能）
     *
     * @param date
     * @return
     */
    @Select({
            "select count(1) as count, f.fc_name as funcName ",
            "from func_hits h left join func_function f ",
            "on h.ht_fc_id = f.fc_id and date_format(ht_date, '%Y-%m-%d') = #{date}",
            "group by f.fc_id , f.fc_name ",
            "ORDER BY f.fc_id "
    })
    @Results(id = "FunctionUsageDetailResult", value = {
            @Result(column = "funcName", property = "funcName"),
            @Result(column = "count", property = "count"),
            @Result(column = "proportion", property = "proportion")
    })
    List<FunctionUsageDetail> selectFunctionsByDate(@Param("date") String date);

    /**
     * 根据指定日期范围查找 被使用过的功能的 功能名 及其 使用量 （不包含未被使用过的功能）
     * @param startDate
     * @param endDate
     * @return
     */
    @Select({
            "select count(1) as count, f.fc_name as funcName ",
            "from func_hits h left join func_function f ",
            "on h.ht_fc_id = f.fc_id ",
            "and date_format(ht_date, '%Y-%m-%d') ",
            "between date_format(#{startDate}, '%Y-%m-%d')  and date_format(#{endDate}, '%Y-%m-%d')",
            "group by f.fc_id , f.fc_name ",
            "ORDER BY f.fc_id "
    })
    @ResultMap("FunctionUsageDetailResult")
    List<FunctionUsageDetail> selectFunctionsWithinRange(@Param("startDate") String startDate, @Param("endDate") String endDate);


}
