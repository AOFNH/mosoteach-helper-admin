package com.mshelper.dms.controller;

import com.github.pagehelper.PageInfo;
import com.mshelper.dms.po.FuncFunction;
import com.mshelper.dms.service.FuncFunctionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/function")
@Api(tags = "功能接口")
public class FunctionController {

    @Autowired
    private FuncFunctionService functionService;

    @RequestMapping(value = "/getAllFunctions", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有功能")
    public List<FuncFunction> getAllFunctions(){
        List<FuncFunction> allFunctions = functionService.findAllFunctions();
        return  allFunctions;
    }

    @RequestMapping(value = "/getAllFunctionsByPageNum/{pageNum}/{pageSize}", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询所有功能")
    public PageInfo<FuncFunction> getAllFunctionsByPage(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<FuncFunction> functionsPageInfo = functionService.findAllFunctions(pageNum, pageSize);
        return  functionsPageInfo;
    }


    @RequestMapping(value = "/getFunctionById/{funcId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据id查询对应功能")
    public FuncFunction getFunctionById(@PathVariable long funcId){
        FuncFunction function = functionService.findFunctionById(funcId);
        return function;
    }

    @RequestMapping(value = "/saveOrUpdateFunction", method = RequestMethod.POST)
    @ApiOperation(value = "保存或更新功能")
    public String saveOrUpdateFunction(FuncFunction function){
        functionService.saveOrUpdate(function);
        return "操作成功";
    }

    @RequestMapping(value = "/removeFunctionById", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据id删除功能")
    public String removeFunctionById(@RequestParam Long funcId){
        functionService.deleteFunctionById(funcId);
        return "删除成功";
    }
    @RequestMapping(value = "/syncData", method = RequestMethod.GET)
    @ApiOperation(value = "同步各功能使用总量")
    public String syncData(){
        functionService.synchronizeData();
        return "同步成功";
    }


}
