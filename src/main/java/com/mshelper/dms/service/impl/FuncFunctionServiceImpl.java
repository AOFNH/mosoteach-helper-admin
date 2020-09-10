package com.mshelper.dms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mshelper.dms.dao.FuncFunctionMapper;
import com.mshelper.dms.po.FuncFunction;
import com.mshelper.dms.service.FuncFunctionService;
import com.mshelper.dms.service.FuncHitsService;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.mshelper.dms.dao.FuncFunctionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @author Bellamy
 */
@Service
@Transactional
public class FuncFunctionServiceImpl implements FuncFunctionService {

    @Autowired
    private FuncFunctionMapper functionMapper;
    @Autowired
    private FuncHitsService hitsService;

    @Override
    public List<FuncFunction> findAllFunctions() {

        //查找前先更新各功能的使用总量
        hitsService.flushAllFunctionsHits();

        SelectStatementProvider selectStatement = select(fcId, fcNo, fcName, fcStatus, fcHits)
                .from(funcFunction)
                .build()
                .render(RenderingStrategies.MYBATIS3);

        List<FuncFunction> functions = functionMapper.selectMany(selectStatement);
        return functions;
    }

    @Override
    public PageInfo<FuncFunction> findAllFunctions(int pageNum, int pageSize) {

        //查找前先更新各功能的使用总量
        hitsService.flushAllFunctionsHits();

        PageHelper.startPage(pageNum, pageSize);
        SelectStatementProvider select = select(fcId, fcName,fcNo, fcStatus,fcHits)
                .from(funcFunction)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<FuncFunction> list = functionMapper.selectMany(select);
        PageInfo<FuncFunction> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public FuncFunction findFunctionById(long funcId) {
        return functionMapper.selectByPrimaryKey(funcId);
    }

    @Override
    public void saveOrUpdate(FuncFunction function) {
        if(function.getFcId() == null){
            functionMapper.insert(function);
        }else{
            functionMapper.updateByPrimaryKeySelective(function);
        }
    }

    @Override
    public void deleteFunctionById(long funcId) {

        functionMapper.deleteByPrimaryKey(funcId);
    }

    @Override
    public String findFunctionNameById(Long funcId) {

        SelectStatementProvider render = select(fcName)
                .from(funcFunction)
                .where(fcId, isEqualTo(funcId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        FuncFunction function = functionMapper.selectOne(render);
        return function.getFcName();
    }

    @Override
    public void synchronizeData() {
        hitsService.flushAllFunctionsHits();
    }

}
