package com.mshelper.dms.dao;

import com.mshelper.dms.po.SysRole;
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

import static com.mshelper.dms.dao.SysRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Repository
@Mapper
public interface SysRoleMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source Table: sys_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<SysRole> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysRoleResult")
    SysRole selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysRoleResult", value = {
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_desc", property="roleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_flag", property="roleFlag", jdbcType=JdbcType.INTEGER)
    })
    List<SysRole> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(sysRole);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, sysRole);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default int deleteByPrimaryKey(Long roleId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, sysRole)
                .where(roleId, isEqualTo(roleId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default int insert(SysRole record) {
        return insert(SqlBuilder.insert(record)
                .into(sysRole)
                .map(roleId).toProperty("roleId")
                .map(roleName).toProperty("roleName")
                .map(roleDesc).toProperty("roleDesc")
                .map(roleFlag).toProperty("roleFlag")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default int insertSelective(SysRole record) {
        return insert(SqlBuilder.insert(record)
                .into(sysRole)
                .map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
                .map(roleName).toPropertyWhenPresent("roleName", record::getRoleName)
                .map(roleDesc).toPropertyWhenPresent("roleDesc", record::getRoleDesc)
                .map(roleFlag).toPropertyWhenPresent("roleFlag", record::getRoleFlag)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<SysRole>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, roleId, roleName, roleDesc, roleFlag)
                .from(sysRole);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<SysRole>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, roleId, roleName, roleDesc, roleFlag)
                .from(sysRole);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default SysRole selectByPrimaryKey(Long roleId_) {
        return SelectDSL.selectWithMapper(this::selectOne, roleId, roleName, roleDesc, roleFlag)
                .from(sysRole)
                .where(roleId, isEqualTo(roleId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(SysRole record) {
        return UpdateDSL.updateWithMapper(this::update, sysRole)
                .set(roleId).equalTo(record::getRoleId)
                .set(roleName).equalTo(record::getRoleName)
                .set(roleDesc).equalTo(record::getRoleDesc)
                .set(roleFlag).equalTo(record::getRoleFlag);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(SysRole record) {
        return UpdateDSL.updateWithMapper(this::update, sysRole)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(roleName).equalToWhenPresent(record::getRoleName)
                .set(roleDesc).equalToWhenPresent(record::getRoleDesc)
                .set(roleFlag).equalToWhenPresent(record::getRoleFlag);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default int updateByPrimaryKey(SysRole record) {
        return UpdateDSL.updateWithMapper(this::update, sysRole)
                .set(roleName).equalTo(record::getRoleName)
                .set(roleDesc).equalTo(record::getRoleDesc)
                .set(roleFlag).equalTo(record::getRoleFlag)
                .where(roleId, isEqualTo(record::getRoleId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.668+08:00", comments="Source Table: sys_role")
    default int updateByPrimaryKeySelective(SysRole record) {
        return UpdateDSL.updateWithMapper(this::update, sysRole)
                .set(roleName).equalToWhenPresent(record::getRoleName)
                .set(roleDesc).equalToWhenPresent(record::getRoleDesc)
                .set(roleFlag).equalToWhenPresent(record::getRoleFlag)
                .where(roleId, isEqualTo(record::getRoleId))
                .build()
                .execute();
    }
}