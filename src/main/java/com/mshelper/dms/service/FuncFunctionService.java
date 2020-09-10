package com.mshelper.dms.service;

import com.github.pagehelper.PageInfo;
import com.mshelper.dms.po.FuncFunction;

import java.util.List;

public interface FuncFunctionService {

    List<FuncFunction> findAllFunctions();

    PageInfo<FuncFunction> findAllFunctions(int pageNum, int pageSize);

    FuncFunction findFunctionById(long funcId);

    void saveOrUpdate(FuncFunction function);

    void deleteFunctionById(long funcId);

    String findFunctionNameById(Long funcId);

    void synchronizeData();


}
