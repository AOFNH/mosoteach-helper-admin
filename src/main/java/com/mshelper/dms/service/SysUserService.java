package com.mshelper.dms.service;

import com.github.pagehelper.PageInfo;
import com.mshelper.dms.exception.UserException;
import com.mshelper.dms.po.SysUser;

import java.util.List;

/**
 * @author Bellamy
 */
public interface SysUserService {

     SysUser login(String username, String password);

     SysUser findUserById(long userId);

     List<SysUser> findAllUsers();

     PageInfo<SysUser> findUsers(int pageNum, int pageSize);

     List<SysUser> findUsersByRoleId(long roleId);

     PageInfo<SysUser> findUsersByRoleId(long roleId, int pageNum, int pageSize);

     void saveOrUpdate(SysUser user) throws UserException;

     void deleteUserById(long userId);

     SysUser findUserByName(String username);


}
