package com.mshelper.dms.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SysRoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source Table: sys_role")
    public static final SysRole sysRole = new SysRole();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source field: sys_role.role_id")
    public static final SqlColumn<Long> roleId = sysRole.roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source field: sys_role.role_name")
    public static final SqlColumn<String> roleName = sysRole.roleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source field: sys_role.role_desc")
    public static final SqlColumn<String> roleDesc = sysRole.roleDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source field: sys_role.role_flag")
    public static final SqlColumn<Integer> roleFlag = sysRole.roleFlag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source Table: sys_role")
    public static final class SysRole extends SqlTable {
        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public final SqlColumn<String> roleName = column("role_name", JDBCType.VARCHAR);

        public final SqlColumn<String> roleDesc = column("role_desc", JDBCType.VARCHAR);

        public final SqlColumn<Integer> roleFlag = column("role_flag", JDBCType.INTEGER);

        public SysRole() {
            super("sys_role");
        }
    }
}