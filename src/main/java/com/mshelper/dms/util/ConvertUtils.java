package com.mshelper.dms.util;

import com.mshelper.dms.po.FuncFunction;
import com.mshelper.dms.po.FuncHits;
import com.mshelper.dms.service.FuncFunctionService;
import com.mshelper.dms.vo.FunctionUsageDetail;
import com.mshelper.dms.vo.FunctionUsageDetailOnDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Bellamy
 */
@Component
public class ConvertUtils {

    private static FuncFunctionService functionService;

    //Spring中使用@Autowired注解静态变量
    @Autowired
    public ConvertUtils(FuncFunctionService functionService) {
        ConvertUtils.functionService = functionService;
    }


    /**
     * 将Map集合转换成前端需要的对象集合
     *
     * @param map 包含了 功能ID 和 对应的 使用次数
     * @param sum 总次数
     * @return
     */
    public static List<FunctionUsageDetail>
    convertToFunctionUsageDetailList(Map<Long, Long> map, Long sum) {

        ArrayList<FunctionUsageDetail> arrayList = new ArrayList<>();
        if (map != null) {

            //补加没有使用记录的功能数据（没有使用，总数为0）
            List<FuncFunction> allFunctions = functionService.findAllFunctions();
            for (FuncFunction f : allFunctions
            ) {
                Long oldValue = map.getOrDefault(f.getFcId(), (long) 0);
                map.put(f.getFcId(), oldValue);
            }

            for (Map.Entry entry : map.entrySet()) {

                Long key = (Long) entry.getKey();
                Long value = (Long) entry.getValue();

                FunctionUsageDetail detail = new FunctionUsageDetail();
                System.out.println("functionService:" + functionService);
                //功能名
                detail.setFuncName(functionService.findFunctionNameById(key));
                //功能使用次数
                detail.setCount(value);
                //总次数占比
                detail.setProportion((float) value / sum);
                arrayList.add(detail);
            }
        }
        return arrayList;

    }


    /**
     * 将Map集合转换成前端需要的对象集合
     *
     * @param map 包含了 日期  和  对应日期 使用的次数
     * @return
     */
    public static List<FunctionUsageDetailOnDate>
    convertToFunctionUsageDetailOnDateList(Map<String, Long> map) {

        ArrayList<FunctionUsageDetailOnDate> arrayList = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()
        ) {
            FunctionUsageDetailOnDate detail = new FunctionUsageDetailOnDate();
            detail.setDate((String) entry.getKey());
            detail.setCount((Long) entry.getValue());
            arrayList.add(detail);
        }
        return arrayList;
    }

    /**
     * 计算各日该功能被使用的次数
     *
     * @param list 某一功能被使用时所在日期的集合
     * @return map  每日该功能的被使用量 的集合
     */
    public static Map<String, Long> getHitsMap(List<FuncHits> list) {

        TreeMap<String, Long> map = new TreeMap<>();
        for (FuncHits l : list
        ) {
            Long oldValue = map.getOrDefault(dateFormat(l.getHtDate()), 0L);
            System.out.println("1:" + l.getHtDate());
            System.out.println("2:" + dateFormat(l.getHtDate()));
            map.put(dateFormat(l.getHtDate()), oldValue + 1);
        }
        return map;
    }


    /**
     * Date 转成指定格式的日期String
     *
     * @param date
     * @param pattern 默认为 yyyy-MM-dd 格式
     * @return
     */
    public static String dateFormat(Date date, String pattern) {

        pattern = pattern == null ? "yyyy-MM-dd" : pattern;

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);

        //dateFormat.format  Date => String
        //dateFormat.parse  String => Date

    }

    public static String dateFormat(Date date) {
        return dateFormat(date, null);
    }


    public static List<FunctionUsageDetail> getAllFunctionsUsageDetails(Boolean isShowOthers, List<FunctionUsageDetail> list) {
        List<FuncFunction> allFunctions = functionService.findAllFunctions();

        //将 功能使用量 和 名称 转存为 Map
        HashMap<String, Long> stringLongHashMap = new HashMap<>();
        for (FunctionUsageDetail f : list
        ) {
            stringLongHashMap.put(f.getFuncName(), f.getCount());
        }

        //如果选择不显示其他日统计总数，需要移除 key 为 null 的 entry
        if(!isShowOthers){
            stringLongHashMap.remove(null);
        }

        //添加 没有使用记录的功能 ，并记其 使用量 为 0
        for (FuncFunction f : allFunctions
        ) {
            Long oldVal = stringLongHashMap.getOrDefault(f.getFcName(), 0L);
            stringLongHashMap.put(f.getFcName(), oldVal);
        }
        //计算所有功能的使用总量
        Long total = 0L;
        for (Long count : stringLongHashMap.values()
        ) {
            total += count;
        }
        //计算各功能的使用量的总量占比
        ArrayList<FunctionUsageDetail> arrayList = new ArrayList<>();
        for (Map.Entry entry : stringLongHashMap.entrySet()
        ) {
            float proportion = 0.0F;
            Long val = (Long) entry.getValue();
            proportion =  (float) val / total;

            FunctionUsageDetail detail = new FunctionUsageDetail();
            String funcName = (String) entry.getKey() == null ? "其他总计" : (String) entry.getKey();
            detail.setFuncName(funcName);
            detail.setCount((Long) entry.getValue());
            detail.setProportion(proportion);

            arrayList.add(detail);
        }
        return arrayList;
    }


}
