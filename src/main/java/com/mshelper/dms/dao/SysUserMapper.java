package com.mshelper.dms.dao;

import com.mshelper.dms.po.SysUser;
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

import static com.mshelper.dms.dao.SysUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
@Mapper
public interface SysUserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source Table: sys_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source Table: sys_user")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source Table: sys_user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SysUser> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source Table: sys_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysUserResult")
    SysUser selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source Table: sys_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysUserResult", value = {
        @Result(column="usr_id", property="usrId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="usr_role_id", property="usrRoleId", jdbcType=JdbcType.BIGINT),
        @Result(column="usr_name", property="usrName", jdbcType=JdbcType.VARCHAR),
        @Result(column="usr_password", property="usrPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="usr_role_name", property="usrRoleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="usr_flag", property="usrFlag", jdbcType=JdbcType.INTEGER)
    })
    List<SysUser> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(sysUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, sysUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default int deleteByPrimaryKey(Long usrId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, sysUser)
                .where(usrId, isEqualTo(usrId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default int insert(SysUser record) {
        return insert(SqlBuilder.insert(record)
                .into(sysUser)
                .map(usrId).toProperty("usrId")
                .map(usrRoleId).toProperty("usrRoleId")
                .map(usrName).toProperty("usrName")
                .map(usrPassword).toProperty("usrPassword")
                .map(usrRoleName).toProperty("usrRoleName")
                .map(usrFlag).toProperty("usrFlag")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default int insertSelective(SysUser record) {
        return insert(SqlBuilder.insert(record)
                .into(sysUser)
                .map(usrId).toPropertyWhenPresent("usrId", record::getUsrId)
                .map(usrRoleId).toPropertyWhenPresent("usrRoleId", record::getUsrRoleId)
                .map(usrName).toPropertyWhenPresent("usrName", record::getUsrName)
                .map(usrPassword).toPropertyWhenPresent("usrPassword", record::getUsrPassword)
                .map(usrRoleName).toPropertyWhenPresent("usrRoleName", record::getUsrRoleName)
                .map(usrFlag).toPropertyWhenPresent("usrFlag", record::getUsrFlag)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<SysUser>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, usrId, usrRoleId, usrName, usrPassword, usrRoleName, usrFlag)
                .from(sysUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<SysUser>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, usrId, usrRoleId, usrName, usrPassword, usrRoleName, usrFlag)
                .from(sysUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default SysUser selectByPrimaryKey(Long usrId_) {
        return SelectDSL.selectWithMapper(this::selectOne, usrId, usrRoleId, usrName, usrPassword, usrRoleName, usrFlag)
                .from(sysUser)
                .where(usrId, isEqualTo(usrId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(SysUser record) {
        return UpdateDSL.updateWithMapper(this::update, sysUser)
                .set(usrId).equalTo(record::getUsrId)
                .set(usrRoleId).equalTo(record::getUsrRoleId)
                .set(usrName).equalTo(record::getUsrName)
                .set(usrPassword).equalTo(record::getUsrPassword)
                .set(usrRoleName).equalTo(record::getUsrRoleName)
                .set(usrFlag).equalTo(record::getUsrFlag);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(SysUser record) {
        return UpdateDSL.updateWithMapper(this::update, sysUser)
                .set(usrId).equalToWhenPresent(record::getUsrId)
                .set(usrRoleId).equalToWhenPresent(record::getUsrRoleId)
                .set(usrName).equalToWhenPresent(record::getUsrName)
                .set(usrPassword).equalToWhenPresent(record::getUsrPassword)
                .set(usrRoleName).equalToWhenPresent(record::getUsrRoleName)
                .set(usrFlag).equalToWhenPresent(record::getUsrFlag);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default int updateByPrimaryKey(SysUser record) {
        return UpdateDSL.updateWithMapper(this::update, sysUser)
                .set(usrRoleId).equalTo(record::getUsrRoleId)
                .set(usrName).equalTo(record::getUsrName)
                .set(usrPassword).equalTo(record::getUsrPassword)
                .set(usrRoleName).equalTo(record::getUsrRoleName)
                .set(usrFlag).equalTo(record::getUsrFlag)
                .where(usrId, isEqualTo(record::getUsrId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.671+08:00", comments="Source Table: sys_user")
    default int updateByPrimaryKeySelective(SysUser record) {
        return UpdateDSL.updateWithMapper(this::update, sysUser)
                .set(usrRoleId).equalToWhenPresent(record::getUsrRoleId)
                .set(usrName).equalToWhenPresent(record::getUsrName)
                .set(usrPassword).equalToWhenPresent(record::getUsrPassword)
                .set(usrRoleName).equalToWhenPresent(record::getUsrRoleName)
                .set(usrFlag).equalToWhenPresent(record::getUsrFlag)
                .where(usrId, isEqualTo(record::getUsrId))
                .build()
                .execute();
    }
}