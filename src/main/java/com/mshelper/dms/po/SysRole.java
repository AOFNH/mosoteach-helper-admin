package com.mshelper.dms.po;

import javax.annotation.Generated;

public class SysRole {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source field: sys_role.role_id")
    private Long roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source field: sys_role.role_name")
    private String roleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source field: sys_role.role_desc")
    private String roleDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source field: sys_role.role_flag")
    private Integer roleFlag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source field: sys_role.role_id")
    public Long getRoleId() {
        return roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source field: sys_role.role_id")
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source field: sys_role.role_name")
    public String getRoleName() {
        return roleName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.666+08:00", comments="Source field: sys_role.role_name")
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source field: sys_role.role_desc")
    public String getRoleDesc() {
        return roleDesc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source field: sys_role.role_desc")
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source field: sys_role.role_flag")
    public Integer getRoleFlag() {
        return roleFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.667+08:00", comments="Source field: sys_role.role_flag")
    public void setRoleFlag(Integer roleFlag) {
        this.roleFlag = roleFlag;
    }
}