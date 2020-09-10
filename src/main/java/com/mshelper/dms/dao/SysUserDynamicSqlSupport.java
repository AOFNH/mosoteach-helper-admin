package com.mshelper.dms.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SysUserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source Table: sys_user")
    public static final SysUser sysUser = new SysUser();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source field: sys_user.usr_id")
    public static final SqlColumn<Long> usrId = sysUser.usrId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source field: sys_user.usr_role_id")
    public static final SqlColumn<Long> usrRoleId = sysUser.usrRoleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source field: sys_user.usr_name")
    public static final SqlColumn<String> usrName = sysUser.usrName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source field: sys_user.usr_password")
    public static final SqlColumn<String> usrPassword = sysUser.usrPassword;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source field: sys_user.usr_role_name")
    public static final SqlColumn<String> usrRoleName = sysUser.usrRoleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source field: sys_user.usr_flag")
    public static final SqlColumn<Integer> usrFlag = sysUser.usrFlag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source Table: sys_user")
    public static final class SysUser extends SqlTable {
        public final SqlColumn<Long> usrId = column("usr_id", JDBCType.BIGINT);

        public final SqlColumn<Long> usrRoleId = column("usr_role_id", JDBCType.BIGINT);

        public final SqlColumn<String> usrName = column("usr_name", JDBCType.VARCHAR);

        public final SqlColumn<String> usrPassword = column("usr_password", JDBCType.VARCHAR);

        public final SqlColumn<String> usrRoleName = column("usr_role_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> usrFlag = column("usr_flag", JDBCType.INTEGER);

        public SysUser() {
            super("sys_user");
        }
    }
}