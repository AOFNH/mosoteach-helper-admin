package com.mshelper.dms.po;

import javax.annotation.Generated;

public class SysUser {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_id")
    private Long usrId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_role_id")
    private Long usrRoleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_name")
    private String usrName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_password")
    private String usrPassword;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_role_name")
    private String usrRoleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_flag")
    private Integer usrFlag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_id")
    public Long getUsrId() {
        return usrId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_id")
    public void setUsrId(Long usrId) {
        this.usrId = usrId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_role_id")
    public Long getUsrRoleId() {
        return usrRoleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_role_id")
    public void setUsrRoleId(Long usrRoleId) {
        this.usrRoleId = usrRoleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_name")
    public String getUsrName() {
        return usrName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_name")
    public void setUsrName(String usrName) {
        this.usrName = usrName == null ? null : usrName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_password")
    public String getUsrPassword() {
        return usrPassword;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_password")
    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword == null ? null : usrPassword.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_role_name")
    public String getUsrRoleName() {
        return usrRoleName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_role_name")
    public void setUsrRoleName(String usrRoleName) {
        this.usrRoleName = usrRoleName == null ? null : usrRoleName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.669+08:00", comments="Source field: sys_user.usr_flag")
    public Integer getUsrFlag() {
        return usrFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.67+08:00", comments="Source field: sys_user.usr_flag")
    public void setUsrFlag(Integer usrFlag) {
        this.usrFlag = usrFlag;
    }
}