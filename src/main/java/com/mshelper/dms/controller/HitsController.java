package com.mshelper.dms.controller;

import com.mshelper.dms.po.FuncHits;
import com.mshelper.dms.service.FuncHitsService;
import com.mshelper.dms.vo.FunctionUsageDetail;
import com.mshelper.dms.vo.FunctionUsageDetailOnDate;
import com.mshelper.dms.vo.SubtotalWithinTimeUnit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/hits")
@Api(tags = "功能使用记录接口")
public class HitsController {

    @Autowired
    private FuncHitsService hitsService;

    /**
     * 字符串日期转Date
     *
     * @param request
     * @param binder
     */
    @InitBinder
    public void init(HttpServletRequest request, WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

    }

    @RequestMapping(value = "/getDataByFuncID/{funcId}", method = RequestMethod.GET)
    @ApiOperation(value = "获取指定功能的日使用数据")
   public List<FunctionUsageDetailOnDate> getDataByFuncID(@PathVariable Long funcId) {
        List<FunctionUsageDetailOnDate> list = hitsService.findThisFuncUsageDetailGroupDay(funcId);
        return list;
    }

    @RequestMapping(value = "/getDataByFuncIdAndMonth/{funcId}/{month}", method = RequestMethod.GET)
    @ApiOperation(value = "根据功能id查询指定月份的日使用记录")
    public List<FunctionUsageDetailOnDate> getDataByFuncIdAndMonth(@PathVariable Long funcId, @PathVariable String month) {

        List<FunctionUsageDetailOnDate> list = hitsService
                .findThisFuncUsageDetailGroupDay(funcId, month);
        return list;
    }

    @RequestMapping(value = "/getDataByFuncIdAndInterval/{funcId}/{startDate}/{endDate}", method = RequestMethod.GET)
    @ApiOperation(value = "根据功能id查询指定时间段内的日使用记录")
    public List<FunctionUsageDetailOnDate> getDataByFuncIdAndInterval
            (@PathVariable Long funcId,
             @PathVariable String startDate,
             @PathVariable String endDate) {

        List<FunctionUsageDetailOnDate> list = hitsService.findThisFuncUsageDetailGroupDay(funcId, startDate, endDate);
        return list;
    }

    @RequestMapping(value = "/getMonthlyDataByFuncIdAndYear/{funcId}/{year}", method = RequestMethod.GET)
    @ApiOperation(value = "获取该功能的在指定年份的月使用数据")
    public List<SubtotalWithinTimeUnit> getMonthlyDataByFuncIdAndYear(@PathVariable Long funcId, @PathVariable String year) {
        List<SubtotalWithinTimeUnit> list = hitsService.findThisFuncUsageDetailGroupMonth(funcId, year);
        return list;
    }

    /**
     * @param funcId
     * @param timeUnit 时间单位 pattern   年 %Y   or  月 %Y-%m  or 周 %Y-%u  or 日 %Y-%m-%d  ...
     *                 pattern ： https://www.w3school.com.cn/sql/func_date_format.asp
     * @return
     */
    @RequestMapping(value = "/getDataWithinByFuncIdAndTimeUnit/{funcId}/{timeUnit}", method = RequestMethod.GET)
    @ApiOperation(value = "获取指定时间单位内指定功能的使用数据（timeUnit 格式：年 Y 、月 Y-m 、周 Y-u 、 日 Y-m-d ）")
    public List<SubtotalWithinTimeUnit> getDataWithinByFuncIdAndTimeUnit(@PathVariable Long funcId, @PathVariable String timeUnit) {

        String[] split = timeUnit.split("-");
        StringBuffer timeUnitStr = new StringBuffer();
        for (String s:split
             ) {
            timeUnitStr.append("%").append(s);
        }
        List<SubtotalWithinTimeUnit> list = hitsService.findThisFuncUsageDetailByFuncIdAndTimeUnit(funcId, timeUnitStr.toString());
        return list;
    }

    @RequestMapping(value = "/getAllFunctionsSubtotalByUserId/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "获取指定用户各功能使用数据（总量及占比）")
    public List<FunctionUsageDetail> getAllFunctionsSubtotalByUserId(@PathVariable Long userId) {

        return hitsService.findUserUsageDetailByUserId(userId);
    }

    @RequestMapping(value = "/getAllFunctionsSubtotal", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有功能的使用数据（总量及占比）")
    public List<FunctionUsageDetail> getAllFunctionsSubtotal() {
        return hitsService.findAllFunctionUsageDetail();
    }

    //POST 存在跨域请求问题 CORS

    @RequestMapping(value = "/saveOrUpdateUsePost", method = RequestMethod.POST)
    @ApiOperation(value = "保存或更新一条功能使用记录")
    public String saveOrUpdateUsePost(FuncHits funcHits, HttpServletResponse response) {

        funcHits.setHtDate(new Date());
        funcHits.setHtUsrId(funcHits.getHtUsrId() == null ? 0 : funcHits.getHtUsrId());
        hitsService.saveOrUpdate(funcHits);
        response.addHeader("Access-Control-Allow-Origin", "*");
        return "操作成功";

    }

    @RequestMapping(value = "/saveOrUpdateUsePostWithoutCORS", method = RequestMethod.POST)
    @ApiOperation(value = "保存或更新一条功能使用记录")
    public String saveOrUpdateUsePostWithoutCORS(FuncHits funcHits, HttpServletResponse response) {

        funcHits.setHtDate(new Date());
        funcHits.setHtUsrId(funcHits.getHtUsrId() == null ? 0 : funcHits.getHtUsrId());
        hitsService.saveOrUpdate(funcHits);
        return "操作成功";

    }

    @RequestMapping(value = "/saveOrUpdateUseGet", method = RequestMethod.GET)
    @ApiOperation(value = "保存或更新一条功能使用记录")
    public String saveOrUpdateUseGet(FuncHits funcHits) {

        funcHits.setHtDate(new Date());
        funcHits.setHtUsrId(funcHits.getHtUsrId() == null ? 0 : funcHits.getHtUsrId());
        hitsService.saveOrUpdate(funcHits);
        return "操作成功";

    }




}
