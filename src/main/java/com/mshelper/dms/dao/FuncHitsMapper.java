package com.mshelper.dms.dao;

import com.mshelper.dms.po.FuncHits;
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

import static com.mshelper.dms.dao.FuncHitsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Repository
@Mapper
public interface FuncHitsMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<FuncHits> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("FuncHitsResult")
    FuncHits selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="FuncHitsResult", value = {
        @Result(column="ht_id", property="htId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ht_fc_id", property="htFcId", jdbcType=JdbcType.BIGINT),
        @Result(column="ht_date", property="htDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ht_usr_id", property="htUsrId", jdbcType=JdbcType.BIGINT)
    })
    List<FuncHits> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(funcHits);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, funcHits);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    default int deleteByPrimaryKey(Long htId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, funcHits)
                .where(htId, isEqualTo(htId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    default int insert(FuncHits record) {
        return insert(SqlBuilder.insert(record)
                .into(funcHits)
                .map(htId).toProperty("htId")
                .map(htFcId).toProperty("htFcId")
                .map(htDate).toProperty("htDate")
                .map(htUsrId).toProperty("htUsrId")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source Table: func_hits")
    default int insertSelective(FuncHits record) {
        return insert(SqlBuilder.insert(record)
                .into(funcHits)
                .map(htId).toPropertyWhenPresent("htId", record::getHtId)
                .map(htFcId).toPropertyWhenPresent("htFcId", record::getHtFcId)
                .map(htDate).toPropertyWhenPresent("htDate", record::getHtDate)
                .map(htUsrId).toPropertyWhenPresent("htUsrId", record::getHtUsrId)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source Table: func_hits")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<FuncHits>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, htId, htFcId, htDate, htUsrId)
                .from(funcHits);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source Table: func_hits")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<FuncHits>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, htId, htFcId, htDate, htUsrId)
                .from(funcHits);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source Table: func_hits")
    default FuncHits selectByPrimaryKey(Long htId_) {
        return SelectDSL.selectWithMapper(this::selectOne, htId, htFcId, htDate, htUsrId)
                .from(funcHits)
                .where(htId, isEqualTo(htId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source Table: func_hits")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(FuncHits record) {
        return UpdateDSL.updateWithMapper(this::update, funcHits)
                .set(htId).equalTo(record::getHtId)
                .set(htFcId).equalTo(record::getHtFcId)
                .set(htDate).equalTo(record::getHtDate)
                .set(htUsrId).equalTo(record::getHtUsrId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source Table: func_hits")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(FuncHits record) {
        return UpdateDSL.updateWithMapper(this::update, funcHits)
                .set(htId).equalToWhenPresent(record::getHtId)
                .set(htFcId).equalToWhenPresent(record::getHtFcId)
                .set(htDate).equalToWhenPresent(record::getHtDate)
                .set(htUsrId).equalToWhenPresent(record::getHtUsrId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source Table: func_hits")
    default int updateByPrimaryKey(FuncHits record) {
        return UpdateDSL.updateWithMapper(this::update, funcHits)
                .set(htFcId).equalTo(record::getHtFcId)
                .set(htDate).equalTo(record::getHtDate)
                .set(htUsrId).equalTo(record::getHtUsrId)
                .where(htId, isEqualTo(record::getHtId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source Table: func_hits")
    default int updateByPrimaryKeySelective(FuncHits record) {
        return UpdateDSL.updateWithMapper(this::update, funcHits)
                .set(htFcId).equalToWhenPresent(record::getHtFcId)
                .set(htDate).equalToWhenPresent(record::getHtDate)
                .set(htUsrId).equalToWhenPresent(record::getHtUsrId)
                .where(htId, isEqualTo(record::getHtId))
                .build()
                .execute();
    }
}