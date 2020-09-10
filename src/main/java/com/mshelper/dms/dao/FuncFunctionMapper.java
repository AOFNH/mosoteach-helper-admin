package com.mshelper.dms.dao;

import com.mshelper.dms.po.FuncFunction;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.springframework.stereotype.Repository;

import javax.annotation.Generated;
import java.util.List;

import static com.mshelper.dms.dao.FuncFunctionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Repository
@Mapper
public interface FuncFunctionMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.655+08:00", comments="Source Table: func_function")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.656+08:00", comments="Source Table: func_function")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.656+08:00", comments="Source Table: func_function")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<FuncFunction> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.657+08:00", comments="Source Table: func_function")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("FuncFunctionResult")
    FuncFunction selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.657+08:00", comments="Source Table: func_function")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="FuncFunctionResult", value = {
        @Result(column="fc_id", property="fcId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="fc_no", property="fcNo", jdbcType=JdbcType.INTEGER),
        @Result(column="fc_name", property="fcName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fc_status", property="fcStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="fc_hits", property="fcHits", jdbcType=JdbcType.BIGINT)
    })
    List<FuncFunction> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.658+08:00", comments="Source Table: func_function")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.659+08:00", comments="Source Table: func_function")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(funcFunction);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.659+08:00", comments="Source Table: func_function")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, funcFunction);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.659+08:00", comments="Source Table: func_function")
    default int deleteByPrimaryKey(Long fcId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, funcFunction)
                .where(fcId, isEqualTo(fcId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.66+08:00", comments="Source Table: func_function")
    default int insert(FuncFunction record) {
        return insert(SqlBuilder.insert(record)
                .into(funcFunction)
                .map(fcId).toProperty("fcId")
                .map(fcNo).toProperty("fcNo")
                .map(fcName).toProperty("fcName")
                .map(fcStatus).toProperty("fcStatus")
                .map(fcHits).toProperty("fcHits")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.66+08:00", comments="Source Table: func_function")
    default int insertSelective(FuncFunction record) {
        return insert(SqlBuilder.insert(record)
                .into(funcFunction)
                .map(fcId).toPropertyWhenPresent("fcId", record::getFcId)
                .map(fcNo).toPropertyWhenPresent("fcNo", record::getFcNo)
                .map(fcName).toPropertyWhenPresent("fcName", record::getFcName)
                .map(fcStatus).toPropertyWhenPresent("fcStatus", record::getFcStatus)
                .map(fcHits).toPropertyWhenPresent("fcHits", record::getFcHits)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.66+08:00", comments="Source Table: func_function")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<FuncFunction>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, fcId, fcNo, fcName, fcStatus, fcHits)
                .from(funcFunction);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.661+08:00", comments="Source Table: func_function")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<FuncFunction>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, fcId, fcNo, fcName, fcStatus, fcHits)
                .from(funcFunction);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.661+08:00", comments="Source Table: func_function")
    default FuncFunction selectByPrimaryKey(Long fcId_) {
        return SelectDSL.selectWithMapper(this::selectOne, fcId, fcNo, fcName, fcStatus, fcHits)
                .from(funcFunction)
                .where(fcId, isEqualTo(fcId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.661+08:00", comments="Source Table: func_function")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(FuncFunction record) {
        return UpdateDSL.updateWithMapper(this::update, funcFunction)
                .set(fcId).equalTo(record::getFcId)
                .set(fcNo).equalTo(record::getFcNo)
                .set(fcName).equalTo(record::getFcName)
                .set(fcStatus).equalTo(record::getFcStatus)
                .set(fcHits).equalTo(record::getFcHits);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.662+08:00", comments="Source Table: func_function")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(FuncFunction record) {
        return UpdateDSL.updateWithMapper(this::update, funcFunction)
                .set(fcId).equalToWhenPresent(record::getFcId)
                .set(fcNo).equalToWhenPresent(record::getFcNo)
                .set(fcName).equalToWhenPresent(record::getFcName)
                .set(fcStatus).equalToWhenPresent(record::getFcStatus)
                .set(fcHits).equalToWhenPresent(record::getFcHits);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.663+08:00", comments="Source Table: func_function")
    default int updateByPrimaryKey(FuncFunction record) {
        return UpdateDSL.updateWithMapper(this::update, funcFunction)
                .set(fcNo).equalTo(record::getFcNo)
                .set(fcName).equalTo(record::getFcName)
                .set(fcStatus).equalTo(record::getFcStatus)
                .set(fcHits).equalTo(record::getFcHits)
                .where(fcId, isEqualTo(record::getFcId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.663+08:00", comments="Source Table: func_function")
    default int updateByPrimaryKeySelective(FuncFunction record) {
        return UpdateDSL.updateWithMapper(this::update, funcFunction)
                .set(fcNo).equalToWhenPresent(record::getFcNo)
                .set(fcName).equalToWhenPresent(record::getFcName)
                .set(fcStatus).equalToWhenPresent(record::getFcStatus)
                .set(fcHits).equalToWhenPresent(record::getFcHits)
                .where(fcId, isEqualTo(record::getFcId))
                .build()
                .execute();
    }
}