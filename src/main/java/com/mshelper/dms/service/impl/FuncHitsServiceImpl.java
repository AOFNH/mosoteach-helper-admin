package com.mshelper.dms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mshelper.dms.dao.FuncFunctionMapper;
import com.mshelper.dms.dao.FuncHitsMapper;
import com.mshelper.dms.dao.ext.FuncHitsExtMapper;
import com.mshelper.dms.po.FuncFunction;
import com.mshelper.dms.po.FuncHits;
import com.mshelper.dms.service.FuncFunctionService;
import com.mshelper.dms.service.FuncHitsService;
import com.mshelper.dms.util.ConvertUtils;
import com.mshelper.dms.vo.FunctionUsageDetail;
import com.mshelper.dms.vo.FunctionUsageDetailOnDate;
import com.mshelper.dms.vo.SubtotalWithinTimeUnit;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.mshelper.dms.dao.FuncHitsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * @author Bellamy
 */
@Service
@Transactional
public class FuncHitsServiceImpl implements FuncHitsService {

    @Autowired
    private FuncHitsMapper hitsMapper;

    @Autowired
    private FuncFunctionService functionService;

    @Autowired
    private FuncFunctionMapper functionMapper;

    @Autowired
    private FuncHitsExtMapper hitsExtMapper;

    @Override
    public PageInfo<FuncHits> findAllHits(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SelectStatementProvider render = select(htId, htDate, htFcId, htUsrId)
                .from(funcHits)
                .build()
                .render(RenderingStrategies.MYBATIS3);

        List<FuncHits> list = hitsMapper.selectMany(render);
        return new PageInfo<>(list);
    }

    @Override
    public FuncHits findHitById(long hitId) {
        return hitsMapper.selectByPrimaryKey(hitId);
    }

    @Override
    public List<FuncHits> findHitsByFuncId(long funcId) {
        SelectStatementProvider render = select(htId, htDate, htFcId, htUsrId)
                .from(funcHits)
                .where(htFcId, isEqualTo(funcId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return hitsMapper.selectMany(render);
    }

    @Override
    public List<FuncHits> findHitsByUserId(long userId) {
        SelectStatementProvider render = select(htId, htDate, htFcId, htUsrId)
                .from(funcHits)
                .where(htUsrId, isEqualTo(userId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return hitsMapper.selectMany(render);
    }

    @Override
    public List<FunctionUsageDetail> findUserUsageDetailByUserId(long userId) {

        ArrayList<FunctionUsageDetail> arrayList = new ArrayList<>();

        SelectStatementProvider render =
                select(htFcId)
                        .from(funcHits)
                        .where(htUsrId, isEqualTo(userId))
                        .build()
                        .render(RenderingStrategies.MYBATIS3);
        List<FuncHits> list = hitsMapper.selectMany(render);
        //所有功能使用总量
        long sum = list.size();
        //各功能使用量集合
        HashMap<Long, Long> map = new HashMap<>();
        for (FuncHits l : list) {
            Long value = map.getOrDefault(l.getHtFcId(), 0L);
            map.put(l.getHtFcId(), value + 1);
        }

        return ConvertUtils.convertToFunctionUsageDetailList(map, sum);
    }

    @Override
    public List<FunctionUsageDetail> findAllFunctionUsageDetail() {

        //更新主表中各功能的使用总量,返回值中不包含没有使用记录的功能数据
        Map<Long, Long> longLongMap = flushAllFunctionsHits();

        Long sum = 0L;
        for (Long l: longLongMap.values()
             ) {
            sum += l;
        }
        return ConvertUtils.convertToFunctionUsageDetailList(longLongMap, sum);
    }

    @Override
    public List<FunctionUsageDetailOnDate> findThisFuncUsageDetailGroupDay(long funcId) {

        SelectStatementProvider render =
                select(htDate)
                        .from(funcHits)
                        .where(htFcId, isEqualTo(funcId))
                        .build()
                        .render(RenderingStrategies.MYBATIS3);
        List<FuncHits> list = hitsMapper.selectMany(render);
        //去重并计算日使用次数
        Map<String, Long> hitsMap = ConvertUtils.getHitsMap(list);
        //转换成可返回给前端的对象集合
        return ConvertUtils.convertToFunctionUsageDetailOnDateList(hitsMap);
    }

    @Override
    public List<FunctionUsageDetailOnDate> findThisFuncUsageDetailGroupDay(long funcId, String monthString) {


        //new Date("Wed Sep 30 19:48:11 CST 2020");
        List<FuncHits> list = hitsExtMapper.selectByFuncIdAndMonth(funcId, monthString);

        Map<String, Long> hitsMap = ConvertUtils.getHitsMap(list);

        return ConvertUtils.convertToFunctionUsageDetailOnDateList(hitsMap);
    }

    @Override
    public List<FunctionUsageDetailOnDate> findThisFuncUsageDetailGroupDay(long funcId, String startDate, String endDate) {

//        SelectStatementProvider render =
//                select(htDate)
//                        .from(funcHits)
//                        .where(htFcId, isEqualTo(funcId))
//                        .and(htDate, isBetween(startDate).and(endDate))
//                        .build()
//                        .render(RenderingStrategies.MYBATIS3);
//
//        List<FuncHits> list = hitsMapper.selectMany(render);

        List<FuncHits> list = hitsExtMapper.selectByFuncIdAndInterval(funcId, startDate, endDate);
        //去重并计算日使用次数
        Map<String, Long> hitsMap = ConvertUtils.getHitsMap(list);
        //转换成可返回给前端的对象集合
        return ConvertUtils.convertToFunctionUsageDetailOnDateList(hitsMap);

    }

    @Override
    public List<SubtotalWithinTimeUnit> findThisFuncUsageDetailGroupMonth(long funcId, String year) {

        List<SubtotalWithinTimeUnit> list = hitsExtMapper.selectByFuncIdGroupByMonth(funcId, year);
        return list;
    }

    @Override
    public List<SubtotalWithinTimeUnit> findThisFuncUsageDetailByFuncIdAndTimeUnit(Long funcId, String timeUnit) {

        List<SubtotalWithinTimeUnit> list = hitsExtMapper.selectByFuncIdGroupByTimeUnit(funcId, timeUnit);
        return list;
    }

    @Override
    public void saveOrUpdate(FuncHits funcHits) {

        if (funcHits.getHtId() == null) {
            hitsMapper.insert(funcHits);
        } else {
            hitsMapper.updateByPrimaryKeySelective(funcHits);
        }

    }

    @Override
    public void deleteById(long hitsId) {

        hitsMapper.deleteByPrimaryKey(hitsId);
    }

    @Override
    public Map<Long, Long> flushAllFunctionsHits() {
        //重新计算各功能使用总量
        SelectStatementProvider render =
                select(htFcId)
                        .from(funcHits)
                        .build()
                        .render(RenderingStrategies.MYBATIS3);
        List<FuncHits> list = hitsMapper.selectMany(render);

        //去重计算各功能使用总量
        HashMap<Long, Long> map = new HashMap<>();
        for (FuncHits l : list
        ) {
            Long oldValue = map.getOrDefault(l.getHtFcId(), 0L);
            map.put(l.getHtFcId(), oldValue + 1);
        }

        //更新到主表中
        for (Map.Entry entry : map.entrySet()
        ) {
            Long fcId = (Long) entry.getKey();
            Long fcHits = (Long) entry.getValue();
            FuncFunction funcFunction = new FuncFunction();
            funcFunction.setFcId(fcId);
            funcFunction.setFcHits(fcHits);
            functionMapper.updateByPrimaryKeySelective(funcFunction);
        }
        //返回值中不包含没有使用记录的（新）功能
        return map;
    }
}
