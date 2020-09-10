package com.mshelper.dms.dto;

import com.mshelper.dms.po.SysUser;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Bellamy
 *
 * DTO 包含完整的用户信息，根据Token 获取
 *
 */
public class UserAllDetails {

    private SysUser sysUser;

    private UserDetails userDetails;

    public UserAllDetails() {
    }

    public UserAllDetails(SysUser sysUser, UserDetails userDetails) {
        this.sysUser = sysUser;
        this.userDetails = userDetails;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "UserAllDetails{" +
                "sysUser=" + sysUser +
                ", userDetails=" + userDetails +
                '}';
    }
}
