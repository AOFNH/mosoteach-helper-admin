package com.mshelper.dms.service;

import com.github.pagehelper.PageInfo;
import com.mshelper.dms.po.FuncHits;
import com.mshelper.dms.vo.FunctionUsageDetail;
import com.mshelper.dms.vo.FunctionUsageDetailOnDate;
import com.mshelper.dms.vo.SubtotalWithinTimeUnit;

import java.util.List;
import java.util.Map;

/**
 * @author Bellamy
 */
public interface FuncHitsService {

    /**
     * 分页查找所有功能的使用记录
     *
     * @param pageNum
     * @param pageSize
     * @return PageInfo<FuncHits>
     */
    PageInfo<FuncHits> findAllHits(int pageNum, int pageSize);

    /**
     * 根据hitsId查找
     * 该次使用对应的详细信息（用户id, 功能id, 使用时间 ）
     *
     * @param hitId
     * @return FuncHits
     */
    FuncHits findHitById(long hitId);

    /**
     * 根据功能id查找
     * 该功能的被用户使用的所有记录
     *
     * @param funcId
     * @return List<FuncHits>
     */
    List<FuncHits> findHitsByFuncId(long funcId);

    /**
     * 根据用户id查询
     * 该用户所有功能的使用记录（哪个用户 于 哪个时间 使用了 哪个功能）
     * 以 table 呈现
     *
     * @param userId
     * @return List<FuncHits>
     */
    List<FuncHits> findHitsByUserId(long userId);

    /**
     * 所有功能的使用数据
     * <p>
     * 根据userId查询
     * 该用户 所有功能 的使用总量
     *
     * @param userId
     * @return List<FunctionUsageDetail>
     */
    List<FunctionUsageDetail> findUserUsageDetailByUserId(long userId);


    /**
     * 所有功能的使用数据
     * <p>
     * 获取所有功能的 使用量 及 总量占比
     *
     * @return List<FunctionUsageDetail>
     */
    List<FunctionUsageDetail> findAllFunctionUsageDetail();

    /**
     * 粒度：日使用量、单个功能
     * 根据功能id
     * 查询该功能 每天的使用量
     *
     * @param funcId
     * @return List<FunctionUsageDetailOnDate>
     */
    List<FunctionUsageDetailOnDate> findThisFuncUsageDetailGroupDay(long funcId);

    /**
     * 粒度：日使用量、单个功能
     * 根据功能id
     * 查询该功能在 指定月 每天的使用量
     *
     * @param funcId
     * @param month
     * @return
     */
    List<FunctionUsageDetailOnDate> findThisFuncUsageDetailGroupDay(long funcId, String month);

    /**
     * 粒度：日使用量、单个功能
     * 根据功能id
     * 查询该功能在 指定的时间区间中 每天的使用量
     *
     * @param funcId
     * @param startDate
     * @param endDate
     * @return
     */
    List<FunctionUsageDetailOnDate> findThisFuncUsageDetailGroupDay(long funcId, String startDate, String endDate);


    /**
     * 粒度：月使用量、单个功能
     * 根据功能id
     * 查询该功能在指定年份 的 每月的使用量
     *
     * @param funcId
     * @return List<FunctionUsageDetailOnDate>
     */
    List<SubtotalWithinTimeUnit> findThisFuncUsageDetailGroupMonth(long funcId, String year);


    /**
     * 粒度：可变（年/月/周/日。。。）、单个功能
     *
     * 根据指定的时间单位来查找该单位下 各个 次单位时间内 的功能使用量
     * 如： 指定 单位为 年：%Y  ，表示 查询所有年中每月该功能的使用量
     *
     * @param funcId
     * @param timeUnit 时间单位 pattern   年 %Y   or  月 %Y-%m  or 周 %Y-%m-%u  or 日 %Y-%m-%d  ...
     *                 pattern ： https://www.w3school.com.cn/sql/func_date_format.asp
     * @return
     */
    List<SubtotalWithinTimeUnit> findThisFuncUsageDetailByFuncIdAndTimeUnit(Long funcId, String timeUnit);

    /**
     * 更新或保存一条使用记录
     *
     * @param funcHits
     */
    void saveOrUpdate(FuncHits funcHits);

    /**
     * 根据id 删除使用记录
     *
     * @param hitsId
     */
    void deleteById(long hitsId);

    /**
     * 刷新主表中各功能的使用总量
     *
     * @return Map<Long, Long>  functionId, Hits  返回值中不包含没有使用记录的（新）功能
     */
    Map<Long, Long> flushAllFunctionsHits();

}
